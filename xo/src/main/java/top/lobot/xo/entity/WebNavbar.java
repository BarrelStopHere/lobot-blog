package top.lobot.xo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;
import top.lobot.base.entity.BaseEntity;
import lombok.Data;

import java.util.List;

/**
 * 门户页导航栏
 *
 * @author ykr
 * @date 2024/8/2
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("web_navbar")
public class WebNavbar extends BaseEntity<WebNavbar> implements Comparable<WebNavbar> {


    private static final long serialVersionUID = -1279698371229703105L;
    /**
     * 导航栏名称
     */
    private String name;

    /**
     * 导航栏级别 （一级分类，二级分类）
     */
    private Integer navbarLevel;

    /**
     * 导航栏介绍
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
     * 是否显示  1:是  0:否
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
    private WebNavbar parentWebNavbar;

    /**
     * 子菜单
     */
    @TableField(exist = false)
    private List<WebNavbar> childWebNavbar;

    @Override
    public int compareTo(WebNavbar o) {

        if (this.sort >= o.getSort()) {
            return -1;
        }
        return 1;
    }
}
