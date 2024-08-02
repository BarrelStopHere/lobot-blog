package top.lobot.xo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.lobot.xo.entity.Link;
import top.lobot.base.feign.PictureFeignClient;
import top.lobot.utils.CheckUtils;
import top.lobot.utils.RedisUtil;
import top.lobot.utils.ResultUtil;
import top.lobot.utils.StringUtils;
import top.lobot.xo.dto.LinkPageDTO;
import top.lobot.xo.conf.MessageConf;
import top.lobot.xo.conf.RedisConf;
import top.lobot.xo.conf.SQLConf;
import top.lobot.xo.conf.SysConf;
import top.lobot.xo.mapper.LinkMapper;
import top.lobot.xo.service.LinkService;
import top.lobot.xo.utils.RabbitMqUtil;
import top.lobot.xo.utils.WebUtil;
import top.lobot.xo.vo.LinkVO;
import top.lobot.base.enums.ELinkStatus;
import top.lobot.base.enums.EStatus;
import top.lobot.base.conf.BaseSQLConf;
import top.lobot.base.conf.Constants;
import top.lobot.base.mybatis.page.vo.PageVO;
import top.lobot.base.service.impl.SuperServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
@Service
@Slf4j
public class LinkServiceImpl extends SuperServiceImpl<LinkMapper, Link> implements LinkService {

    @Resource
    private LinkMapper linkMapper;
    @Autowired
    private LinkService linkService;
    @Resource
    private PictureFeignClient pictureFeignClient;
    @Autowired
    private WebUtil webUtil;
    @Autowired
    private RabbitMqUtil rabbitMqUtil;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<Link> getListByPageSize(Integer pageSize) {
        QueryWrapper<Link> queryWrapper = new QueryWrapper<>();
        Page<Link> page = new Page<>();
        page.setCurrent(1);
        page.setSize(pageSize);
        queryWrapper.eq(BaseSQLConf.LINK_STATUS, ELinkStatus.PUBLISH);
        queryWrapper.eq(BaseSQLConf.STATUS, EStatus.ENABLE);
        queryWrapper.orderByDesc(BaseSQLConf.SORT);
        IPage<Link> pageList = linkMapper.selectPage(page, queryWrapper);
        return pageList.getRecords();
    }

    @Override
    public PageVO<Link> getPageList(LinkPageDTO pageDTO) {
        if (StringUtils.isBlank(pageDTO.getOrderByDescColumn()) && StringUtils.isBlank(pageDTO.getOrderByAscColumn())) {
            pageDTO.setOrderByDescColumn(SQLConf.SORT);
        }
        PageVO<Link> pageVO = linkMapper.selectPage(pageDTO);
        List<Link> linkList = pageVO.getRecords();
        if (CollectionUtils.isEmpty(linkList)) {
            return pageVO;
        }

        final StringBuffer fileUids = new StringBuffer();
        // 给友情链接添加图片
        linkList.forEach(item -> {
            if (StringUtils.isNotEmpty(item.getFileUid())) {
                fileUids.append(item.getFileUid() + SysConf.FILE_SEGMENTATION);
            }
        });
        String pictureList = null;
        Map<String, String> pictureMap = new HashMap<>();
        if (fileUids != null) {
            pictureList = pictureFeignClient.getPicture(fileUids.toString(), SysConf.FILE_SEGMENTATION);
        }
        List<Map<String, Object>> picList = webUtil.getPictureMap(pictureList);
        picList.forEach(item -> {
            pictureMap.put(item.get(SysConf.UID).toString(), item.get(SysConf.URL).toString());
        });
        for (Link item : linkList) {
            //获取图片
            if (StringUtils.isNotEmpty(item.getFileUid())) {
                List<String> pictureUidsTemp = StringUtils.changeStringToString(item.getFileUid(), Constants.SYMBOL_COMMA);
                List<String> pictureListTemp = new ArrayList<>();

                pictureUidsTemp.forEach(picture -> {
                    pictureListTemp.add(pictureMap.get(picture));
                });
                item.setPhotoList(pictureListTemp);
            }
        }
        return pageVO;
    }

    @Override
    public String addLink(LinkVO linkVO) {
        Link link = new Link();
        link.setTitle(linkVO.getTitle());
        link.setSummary(linkVO.getSummary());
        link.setUrl(linkVO.getUrl());
        link.setClickCount(0);
        link.setLinkStatus(linkVO.getLinkStatus());
        link.setSort(linkVO.getSort());
        link.setEmail(linkVO.getEmail());
        link.setFileUid(linkVO.getFileUid());
        link.setStatus(EStatus.ENABLE);
        link.setUpdateTime(new Date());
        link.insert();

        // 友链从申请状态到发布状态，需要发送邮件到站长邮箱
        if(StringUtils.isNotEmpty(link.getEmail()) && CheckUtils.checkEmail(link.getEmail())) {
            log.info("发送友链申请通过的邮件通知");
            String linkApplyText =  "<a href=\" " + link.getUrl() + "\">" + link.getTitle() + "</a> 站长，您申请的友链已经成功上架~";
            rabbitMqUtil.sendSimpleEmail(link.getEmail(), linkApplyText);
        }

        // 删除Redis中的BLOG_LINK
        deleteRedisBlogLinkList();

        return ResultUtil.successWithMessage(MessageConf.INSERT_SUCCESS);
    }

    @Override
    public String editLink(LinkVO linkVO) {
        Link link = linkService.getById(linkVO.getUid());
        Integer linkStatus = link.getLinkStatus();
        link.setTitle(linkVO.getTitle());
        link.setSummary(linkVO.getSummary());
        link.setLinkStatus(linkVO.getLinkStatus());
        link.setUrl(linkVO.getUrl());
        link.setSort(linkVO.getSort());
        link.setEmail(linkVO.getEmail());
        link.setFileUid(linkVO.getFileUid());
        link.setUpdateTime(new Date());
        link.updateById();

        // 友链从申请状态到发布状态，需要发送邮件到站长邮箱
        if(StringUtils.isNotEmpty(link.getEmail()) && CheckUtils.checkEmail(link.getEmail())) {
            if(ELinkStatus.APPLY.equals(linkStatus) && ELinkStatus.PUBLISH.equals(linkVO.getLinkStatus())) {
                log.info("发送友链申请通过的邮件通知");
                String linkApplyText =  "<a href=\" " + link.getUrl() + "\">" + link.getTitle() + "</a> 站长，您申请的友链已经成功上架~";
                rabbitMqUtil.sendSimpleEmail(link.getEmail(), linkApplyText);
            }
        }

        // 删除Redis中的BLOG_LINK
        deleteRedisBlogLinkList();

        return ResultUtil.successWithMessage(MessageConf.UPDATE_SUCCESS);
    }

    @Override
    public String deleteLink(LinkVO linkVO) {
        Link link = linkService.getById(linkVO.getUid());
        link.setStatus(EStatus.DISABLED);
        link.setUpdateTime(new Date());
        link.updateById();

        // 删除Redis中的BLOG_LINK
        deleteRedisBlogLinkList();

        return ResultUtil.successWithMessage(MessageConf.DELETE_SUCCESS);
    }

    @Override
    public String stickLink(LinkVO linkVO) {
        Link link = linkService.getById(linkVO.getUid());
        //查找出最大的那一个
        QueryWrapper<Link> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc(SQLConf.SORT);
        Page<Link> page = new Page<>();
        page.setCurrent(0);
        page.setSize(1);
        IPage<Link> pageList = linkService.page(page, queryWrapper);
        List<Link> list = pageList.getRecords();
        Link maxSort = list.get(0);
        if (StringUtils.isEmpty(maxSort.getUid())) {
            return ResultUtil.errorWithMessage(MessageConf.PARAM_INCORRECT);
        }
        if (maxSort.getUid().equals(link.getUid())) {
            return ResultUtil.errorWithMessage(MessageConf.OPERATION_FAIL);
        }
        Integer sortCount = maxSort.getSort() + 1;
        link.setSort(sortCount);
        link.setUpdateTime(new Date());
        link.updateById();
        // 删除Redis中的BLOG_LINK
        deleteRedisBlogLinkList();
        return ResultUtil.successWithMessage(MessageConf.OPERATION_SUCCESS);
    }

    @Override
    public String addLinkCount(String uid) {
        if (StringUtils.isEmpty(uid)) {
            return ResultUtil.errorWithMessage(MessageConf.PARAM_INCORRECT);
        }
        Link link = linkService.getById(uid);
        if (link != null) {
            int count = link.getClickCount() + 1;
            link.setClickCount(count);
            link.updateById();
        } else {
            return ResultUtil.errorWithMessage(MessageConf.PARAM_INCORRECT);
        }
        return ResultUtil.successWithMessage(MessageConf.UPDATE_SUCCESS);
    }

    /**
     * 删除Redis中的友链列表
     */
    private void deleteRedisBlogLinkList() {
        // 删除Redis中的BLOG_LINK
        Set<String> keys = redisUtil.keys(RedisConf.BLOG_LINK + Constants.SYMBOL_COLON + "*");
        redisUtil.delete(keys);
    }
}