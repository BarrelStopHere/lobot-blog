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
public class SubjectItemVO extends BaseVO<SubjectItemVO> {

    /**
     * 专题UID
     */
    private String subjectUid;

    /**
     * 博客UID
     */
    private String blogUid;

    /**
     * 排序字段，数值越大，越靠前
     */
    private int sort;

}
