package top.lobot.xo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lobot.base.entity.BaseEntity;

/**
 * 图片
 *
 * @author ykr
 * @date 2024/8/2
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("picture")
public class Picture extends BaseEntity<Picture> {

    private static final long serialVersionUID = 2646201532621057453L;

    /**
     * 图片的UID
     */
    private String fileUid;

    /**
     * 图片名称
     */
    private String picName;

    /**
     * 所属相册分类UID
     */
    private String pictureSortUid;

    // 以下字段不存入数据库，封装为了方便使用

    /**
     * 图片路径
     */
    @TableField(exist = false)
    private String pictureUrl;

}
