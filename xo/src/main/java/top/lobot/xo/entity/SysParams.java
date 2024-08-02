package top.lobot.xo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import top.lobot.base.entity.BaseEntity;
import lombok.Data;


/**
 * 参数配置
 *
 * @author ykr
 * @date 2024/8/2
 */
@Data
@TableName("sys_params")
public class SysParams extends BaseEntity<SysParams> {

    private static final long serialVersionUID = 4960694439968857676L;
    /**
     * 参数名称
     */
    private String paramsName;

    /**
     * 参数键名
     */
    private String paramsKey;

    /**
     * 参数键值
     */
    private String paramsValue;

    /**
     * 参数类型，是否系统内置（1：是，0：否）
     */
    private Integer paramsType;

    /**
     * 备注
     */
    private String remark;

    /**
     * 排序字段
     */
    private Integer sort;
}
