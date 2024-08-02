package top.lobot.xo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.lobot.xo.entity.Feedback;
import top.lobot.xo.entity.user.User;
import top.lobot.utils.ResultUtil;
import top.lobot.utils.StringUtils;
import top.lobot.xo.conf.MessageConf;
import top.lobot.xo.conf.SysConf;
import top.lobot.xo.mapper.FeedbackMapper;
import top.lobot.xo.service.FeedbackService;
import top.lobot.xo.service.UserService;
import top.lobot.xo.vo.FeedbackVO;
import top.lobot.base.enums.EStatus;
import top.lobot.base.holder.RequestHolder;
import top.lobot.base.mybatis.query.LambdaQueryWrapperPlus;
import top.lobot.base.service.impl.SuperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 反馈表 服务实现类
 *
 * @author 陌溪
 * @date 2018-09-08
 */
@Service
public class FeedbackServiceImpl extends SuperServiceImpl<FeedbackMapper, Feedback> implements FeedbackService {

    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private UserService userService;

    @Override
    public IPage<Feedback> getPageList(FeedbackVO feedbackVO) {
        LambdaQueryWrapperPlus<Feedback> queryWrapper = new LambdaQueryWrapperPlus<>();
        queryWrapper.like(Feedback::getTitle, feedbackVO.getTitle());
        queryWrapper.eq(Feedback::getFeedbackStatus, feedbackVO.getFeedbackStatus());
        queryWrapper.eq(Feedback::getStatus, EStatus.ENABLE);
        queryWrapper.orderByDesc(Feedback::getCreateTime);

        Page<Feedback> page = new Page<>();
        page.setCurrent(feedbackVO.getCurrentPage());
        page.setSize(feedbackVO.getPageSize());

        IPage<Feedback> pageList = feedbackService.page(page, queryWrapper);

        List<Feedback> feedbackList = pageList.getRecords();
        List<String> userUids = feedbackList.stream().filter(item -> StringUtils.isNotEmpty(item.getUserUid()))
                .map(Feedback::getUserUid).collect(Collectors.toList());
        List<User> userList = userService.getUserListByIds(userUids);
        Map<String, User> map = new HashMap<>();
        userList.forEach(item -> {
            item.setPassWord("");
            map.put(item.getUid(), item);
        });

        feedbackList.forEach(item -> {
            if (StringUtils.isNotEmpty(item.getUserUid())) {
                item.setUser(map.get(item.getUserUid()));
            }
        });

        pageList.setRecords(feedbackList);
        return pageList;
    }

    @Override
    public String addFeedback(FeedbackVO feedbackVO) {
        HttpServletRequest request = RequestHolder.getRequest();
        Feedback feedback = feedbackService.getById(feedbackVO.getUid());
        feedback.setTitle(feedbackVO.getTitle());
        feedback.setContent(feedbackVO.getContent());
        feedback.setFeedbackStatus(feedbackVO.getFeedbackStatus());
        feedback.setReply(feedbackVO.getReply());
        feedback.setUpdateTime(new Date());
        if (request.getAttribute(SysConf.ADMIN_UID) != null) {
            feedback.setAdminUid(request.getAttribute(SysConf.ADMIN_UID).toString());
        }
        feedback.setUpdateTime(new Date());
        feedback.updateById();
        return ResultUtil.result(SysConf.SUCCESS, MessageConf.UPDATE_SUCCESS);
    }

    @Override
    public String editFeedback(FeedbackVO feedbackVO) {
        return null;
    }

    @Override
    public String deleteBatchFeedback(List<FeedbackVO> feedbackVOList) {
        HttpServletRequest request = RequestHolder.getRequest();
        final String adminUid = request.getAttribute(SysConf.ADMIN_UID).toString();
        if (feedbackVOList.size() <= 0) {
            return ResultUtil.result(SysConf.ERROR, MessageConf.PARAM_INCORRECT);
        }
        List<String> uids = new ArrayList<>();
        feedbackVOList.forEach(item -> {
            uids.add(item.getUid());
        });

        Collection<Feedback> feedbackList = feedbackService.listByIds(uids);

        feedbackList.forEach(item -> {
            item.setAdminUid(adminUid);
            item.setUpdateTime(new Date());
            item.setStatus(EStatus.DISABLED);
        });

        Boolean save = feedbackService.updateBatchById(feedbackList);

        if (save) {
            return ResultUtil.result(SysConf.SUCCESS, MessageConf.DELETE_SUCCESS);
        } else {
            return ResultUtil.result(SysConf.ERROR, MessageConf.DELETE_FAIL);
        }
    }
}
