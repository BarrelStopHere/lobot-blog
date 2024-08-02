package top.lobot.xo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lobot.base.entity.BaseEntity;

/**
 * 文件
 *
 * @author ykr
 * @date 2024/8/2
 */
@EqualsAndHashCode(callSuper = true)
@TableName("file")
@Data
public class File extends BaseEntity<File> {

    private static final long serialVersionUID = -5233980619773534156L;

    private String fileOldName;

    private Long fileSize;

    private String fileSortUid;

    /**
     * 图片扩展名
     */
    private String picExpandedName;

    /**
     * 图片名称
     */
    private String picName;

    /**
     * 图片url地址
     */
    private String picUrl;

    /**
     * 管理员Uid
     */
    private String adminUid;

    /**
     * 用户Uid
     */
    private String userUid;

    /**
     * 七牛云Url
     */
    private String qiNiuUrl;

    /**
     * Minio文件URL
     */
    private String minioUrl;
}
