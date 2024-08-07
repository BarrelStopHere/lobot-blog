package top.lobot.xo.entity;


import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
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
    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 介绍
     */
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String summary;

    /**
     * 该角色所能管辖的区域
     */
    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private String categoryMenuUids;
}
