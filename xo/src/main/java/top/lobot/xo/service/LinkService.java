package top.lobot.xo.service;

import top.lobot.xo.entity.Link;
import top.lobot.xo.dto.LinkPageDTO;
import top.lobot.xo.vo.LinkVO;
import top.lobot.base.mybatis.page.vo.PageVO;
import top.lobot.base.service.SuperService;

import java.util.List;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
public interface LinkService extends SuperService<Link> {

    /**
     * 通过页大小获取友链列表
     *
     * @param pageSize
     * @return
     */
    public List<Link> getListByPageSize(Integer pageSize);

    /**
     * 获取友链列表
     *
     * @param pageDTO
     * @return
     */
    public PageVO<Link> getPageList(LinkPageDTO pageDTO);

    /**
     * 新增友链
     *
     * @param linkVO
     */
    public String addLink(LinkVO linkVO);

    /**
     * 编辑友链
     *
     * @param linkVO
     */
    public String editLink(LinkVO linkVO);

    /**
     * 删除友链
     *
     * @param linkVO
     */
    public String deleteLink(LinkVO linkVO);

    /**
     * 置顶友链
     *
     * @param linkVO
     */
    public String stickLink(LinkVO linkVO);

    /**
     * 点击友链
     *
     * @return
     */
    public String addLinkCount(String uid);
}
