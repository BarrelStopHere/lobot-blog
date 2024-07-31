package top.lobot.xo.entity.admin;


import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lobot.base.entity.BaseEntity;

/**
 * 角色
 *
 * @author ykr
 * @date 2024/7/31
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Role extends BaseEntity<Role> {
    private static final long serialVersionUID = -2829707122385003024L;
    private String name;
    private String description;
    /** 可操作的菜单/按钮  Json数组 */
    private String categoryMenuIds;
}
