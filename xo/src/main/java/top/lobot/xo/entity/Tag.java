package top.lobot.xo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;
import top.lobot.base.entity.BaseEntity;
import lombok.Data;

/**
 * 标签
 *
 * @author ykr
 * @date 2024/8/2
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("tag")
public class Tag extends BaseEntity<Tag> {

    private static final long serialVersionUID = 2824918219898864943L;

    /**
     * 标签内容
     */
    private String content;

    /**
     * 标签简介
     */
    private int clickCount;

    /**
     * 排序字段，数值越大，越靠前
     */
    private int sort;
}
