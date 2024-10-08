package top.lobot.xo.service;

import top.lobot.xo.entity.CategoryMenu;
import top.lobot.xo.vo.CategoryMenuVO;
import top.lobot.base.service.SuperService;

import java.util.List;
import java.util.Map;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
public interface CategoryMenuService extends SuperService<CategoryMenu> {

    /**
     * 获取菜单列表
     *
     * @param categoryMenuVO
     * @return
     */
    public Map<String, Object> getPageList(CategoryMenuVO categoryMenuVO);

    /**
     * 获取全部菜单列表
     *
     * @param keyword
     * @return
     */
    public List<CategoryMenu> getAllList(String keyword);

    /**
     * 获取所有二级菜单-按钮列表
     *
     * @param keyword
     * @return
     */
    public List<CategoryMenu> getButtonAllList(String keyword);

    /**
     * 新增菜单
     *
     * @param categoryMenuVO
     */
    public String addCategoryMenu(CategoryMenuVO categoryMenuVO);

    /**
     * 编辑菜单
     *
     * @param categoryMenuVO
     */
    public String editCategoryMenu(CategoryMenuVO categoryMenuVO);

    /**
     * 批量删除菜单
     *
     * @param categoryMenuVO
     */
    public String deleteCategoryMenu(CategoryMenuVO categoryMenuVO);

    /**
     * 置顶菜单
     *
     * @param categoryMenuVO
     */
    public String stickCategoryMenu(CategoryMenuVO categoryMenuVO);
}
