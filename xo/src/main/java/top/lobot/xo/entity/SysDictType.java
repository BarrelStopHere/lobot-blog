package top.lobot.xo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;
import top.lobot.base.entity.BaseEntity;
import lombok.Data;


/**
 * 字典类型
 *
 * @author ykr
 * @date 2024/8/2
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("sys_dict_type")
public class SysDictType extends BaseEntity<SysDictType> {

    private static final long serialVersionUID = 4541129893384878107L;
    /**
     * 自增键 oid
     */
    private Long oid;

    /**
     * 字典名称
     */
    private String dictName;

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 是否发布  1：是，0:否，默认为0
     */
    private String isPublish;

    /**
     * 创建人UID
     */
    private String createByUid;

    /**
     * 最后更新人UID
     */
    private String updateByUid;

    /**
     * 备注
     */
    private String remark;

    /**
     * 排序字段
     */
    private Integer sort;

}
