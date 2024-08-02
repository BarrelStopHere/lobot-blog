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
public class StudyVideoVO extends BaseVO<StudyVideoVO> {

    /**
     * 视频名称
     */
    private String name;

    /**
     * 视频简介
     */
    private String summary;

    /**
     * 视频内容介绍
     */
    private String content;

    /**
     * 百度云完整路径
     */
    private String baiduPath;

    /**
     * 视频封面图片UID
     */
    private String fileUid;

    /**
     * 资源分类UID
     */
    private String resourceSortUid;

    /**
     * 无参构造方法，初始化默认值
     */
    StudyVideoVO() {

    }

}
