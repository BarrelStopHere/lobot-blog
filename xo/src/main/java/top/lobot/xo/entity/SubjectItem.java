package top.lobot.xo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;
import top.lobot.base.entity.BaseEntity;
import lombok.Data;

/**
 * 专题item
 *
 * @author ykr
 * @date 2024/8/2
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("subject_item")
public class SubjectItem extends BaseEntity<SubjectItem> {

    private static final long serialVersionUID = 987538149530317336L;

    /**
     * 专题UID
     */
    private String subjectUid;
    /**
     * 博客uid
     */
    private String blogUid;

    /**
     * 排序字段，数值越大，越靠前
     */
    private int sort;

    /**
     * 博客
     */
    @TableField(exist = false)
    private Blog blog;

}
