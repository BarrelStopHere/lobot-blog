package top.lobot.xo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lobot.base.entity.BaseEntity;

/**
 * 存储容量
 *
 * @author ykr
 * @date 2024/8/2
 */
@EqualsAndHashCode(callSuper = true)
@TableName("storage")
@Data
public class Storage extends BaseEntity<Storage> {

    private static final long serialVersionUID = -3012143735838630967L;
    /**
     * 管理员UID
     */
    private String adminUid;

    /**
     * 当前网盘容量
     */
    private long storageSize;

    /**
     * 最大网盘容量
     */
    private long maxStorageSize;
}
