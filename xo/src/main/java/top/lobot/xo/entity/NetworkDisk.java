package top.lobot.xo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lobot.base.entity.BaseEntity;

/**
 * 网盘
 *
 * @author ykr
 * @date 2024/8/2
 */
@EqualsAndHashCode(callSuper = true)
@TableName("network_disk")
@Data
public class NetworkDisk extends BaseEntity<NetworkDisk> {

    private static final long serialVersionUID = -6601564451460690054L;

    /**
     * 管理员UID
     */
    private String adminUid;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 扩展名
     */
    private String extendName;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 上传前名称
     */
    private String fileOldName;

    /**
     * 文件大小
     */
    private long fileSize;

    /**
     * 是否是目录
     */
    private int isDir;

    /**
     * 本地文件URL
     */
    private String localUrl;

    /**
     * 七牛URL
     */
    private String qiNiuUrl;

    /**
     * Minio对象存储URL
     */
    private String minioUrl;

    /**
     * 旧文件名
     */
    @TableField(exist = false)
    private String oldFilePath;

    /**
     * 新文件目录
     */
    @TableField(exist = false)
    private String newFilePath;

    /**
     * 文件
     */
    @TableField(exist = false)
    private String files;

    /**
     * 文件类型
     */
    @TableField(exist = false)
    private int fileType;

    /**
     * 文件URL
     */
    @TableField(exist = false)
    private String fileUrl;
}
