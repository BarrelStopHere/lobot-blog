package top.lobot.xo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import top.lobot.xo.entity.ResourceSort;
import top.lobot.xo.vo.ResourceSortVO;
import top.lobot.base.service.SuperService;

import java.util.List;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
public interface ResourceSortService extends SuperService<ResourceSort> {

    /**
     * 获取资源分类列表
     *
     * @param resourceSortVO
     * @return
     */
    public IPage<ResourceSort> getPageList(ResourceSortVO resourceSortVO);

    /**
     * 新增资源分类
     *
     * @param resourceSortVO
     */
    public String addResourceSort(ResourceSortVO resourceSortVO);

    /**
     * 编辑资源分类
     *
     * @param resourceSortVO
     */
    public String editResourceSort(ResourceSortVO resourceSortVO);

    /**
     * 批量删除资源分类
     *
     * @param resourceSortVOList
     */
    public String deleteBatchResourceSort(List<ResourceSortVO> resourceSortVOList);

    /**
     * 置顶资源分类
     *
     * @param resourceSortVO
     */
    public String stickResourceSort(ResourceSortVO resourceSortVO);
}
