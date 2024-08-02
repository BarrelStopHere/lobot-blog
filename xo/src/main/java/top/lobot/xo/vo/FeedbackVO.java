package top.lobot.xo.vo;


import lombok.Data;
import lombok.ToString;
import top.lobot.base.vo.BaseVO;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
@ToString
@Data
public class FeedbackVO extends BaseVO<FeedbackVO> {

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

}
