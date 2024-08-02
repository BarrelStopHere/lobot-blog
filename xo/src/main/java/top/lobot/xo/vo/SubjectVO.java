package top.lobot.xo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lobot.base.vo.BaseVO;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SubjectVO extends BaseVO<SubjectVO> {

    /**
     * 专题名
     */
    private String subjectName;

    /**
     * 专题介绍
     */
    private String summary;

    /**
     * 封面图片UID
     */
    private String fileUid;

    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * 专题点击数
     */
    private String clickCount;

    /**
     * 专题收藏数
     */
    private String collectCount;
}
