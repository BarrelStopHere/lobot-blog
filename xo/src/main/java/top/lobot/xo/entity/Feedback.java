package top.lobot.xo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lobot.base.entity.BaseEntity;

/**
 * 反馈表
 *
 * @author ykr
 * @date 2024/8/2
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("feedback")
public class Feedback extends BaseEntity<Feedback> {


    private static final long serialVersionUID = -1673816470216459937L;
    /**
     * 管理员UID
     */
    private String adminUid;

    /**
     * 用户uid
     */
    private String userUid;

    /**
     * 标题
     */
    private String title;

    /**
     * 反馈的内容
     */
    private String content;

    /**
     * 回复
     */
    private String reply;

    /**
     * 反馈状态： 0：已开启  1：进行中  2：已完成  3：已拒绝
     */
    private Integer feedbackStatus;

    // 以下字段不存入数据库，封装为了前端使用

    /**
     * 反馈用户
     */
    @TableField(exist = false)
    private User user;

}
