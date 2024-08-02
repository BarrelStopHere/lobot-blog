package top.lobot.base.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author ykr
 * @date 2024/8/1
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseVO<T> extends PageInfo<T> {

    /**
     * 唯一UID
     */
    private String uid;

    private Integer status;
}
