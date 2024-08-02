package top.lobot.xo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lobot.base.entity.BaseEntity;

/**
 * 举报评论
 *
 * @author ykr
 * @date 2024/8/2
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("comment_report")
public class CommentReport extends BaseEntity<CommentReport> {

    private static final long serialVersionUID = -1694414316921731210L;

    /**
     * 举报人UID
     */
    private String userUid;

    /**
     * 被举报的评论Uid
     */
    private String reportCommentUid;

    /**
     * 被举报的用户uid
     */
    private String reportUserUid;


    /**
     * 举报原因
     */
    private String content;

    /**
     * 进展状态: 0 未查看   1: 已查看  2：已处理
     */
    private Integer progress;

}
