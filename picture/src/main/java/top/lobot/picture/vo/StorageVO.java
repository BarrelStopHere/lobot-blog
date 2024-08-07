package top.lobot.picture.vo;

import lombok.EqualsAndHashCode;
import top.lobot.base.vo.BaseVO;
import lombok.Data;

/**
 *
 * @author ykr
 * @date 2024/8/7
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class StorageVO extends BaseVO<StorageVO> {

    /**
     * 管理员UID
     */
    private String adminUid;

    /**
     * 存储大小
     */
    private long storagesize;
}
