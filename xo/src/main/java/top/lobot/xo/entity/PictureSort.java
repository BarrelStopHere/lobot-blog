package top.lobot.xo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import top.lobot.base.entity.BaseEntity;

import java.util.List;

/**
 * 图片分类
 *
 * @author ykr
 * @date 2024/8/2
 */
@Data
@TableName("picture_sort")
public class PictureSort extends BaseEntity<PictureSort> {

    /**
     *
     */
    private static final long serialVersionUID = 3454006152368184626L;

    /**
     * 父UID
     */
    private String parentUid;

    /**
     * 分类名
     */
    private String name;

    /**
     * 分类图片Uid
     */
    private String fileUid;

    /**
     * 排序字段，数值越大，越靠前
     */
    private int sort;

    /**
     * 是否显示  1: 是  0: 否
     */
    private Integer isShow;

    //以下字段不存入数据库

    /**
     * 分类图
     */
    @TableField(exist = false)
    private List<String> photoList;

}
