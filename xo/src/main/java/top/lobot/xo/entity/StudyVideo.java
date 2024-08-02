package top.lobot.xo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lobot.base.entity.BaseEntity;

import java.util.List;

/**
 * 学习视频
 *
 * @author ykr
 * @date 2024/8/2
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("study_video")
public class StudyVideo extends BaseEntity<StudyVideo> {

    private static final long serialVersionUID = 5460666055541063288L;

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
     * 点击数
     */
    private Integer clickCount;

    /**
     * 学习视频标题图
     */
    @TableField(exist = false)
    private List<String> photoList;

    /**
     * 资源分类
     */
    @TableField(exist = false)
    private ResourceSort resourceSort;
}
