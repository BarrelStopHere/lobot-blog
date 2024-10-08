package top.lobot.xo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lobot.base.entity.BaseEntity;

import java.util.List;

/**
 * 菜单/按钮
 *
 * @author ykr
 * @date 2024/7/31
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CategoryMenu extends BaseEntity<CategoryMenu> implements Comparable<CategoryMenu>{
    private static final long serialVersionUID = -6077008940898124883L;
    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单级别 （一级分类，二级分类）
     */
    private Integer menuLevel;

    /**
     * 菜单类型 （菜单，按钮）
     */
    private Integer menuType;

    /**
     * 介绍
     */
    private String summary;

    /**
     * Icon图标
     */
    private String icon;

    /**
     * 父UID
     */
    private String parentUid;

    /**
     * URL地址
     */
    private String url;

    /**
     * 排序字段(越大越靠前)
     */
    private Integer sort;

    /**
     * 是否显示  1: 是  0: 否
     */
    private Integer isShow;

    /**
     * 是否跳转外部URL
     */
    private Integer isJumpExternalUrl;

    /**
     * 父菜单
     */
    @TableField(exist = false)
    private CategoryMenu parentCategoryMenu;

    /**
     * 子菜单
     */
    @TableField(exist = false)
    private List<CategoryMenu> childCategoryMenu;

    @Override
    public int compareTo(CategoryMenu o) {

        if (this.sort >= o.getSort()) {
            return -1;
        }
        return 1;
    }
}
