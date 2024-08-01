package top.lobot.base.exception.exceptionType;

import top.lobot.base.conf.BaseMessageConf;
import top.lobot.base.conf.ErrorCode;

import java.io.Serializable;

/**
 *
 * @author ykr
 * @date 2024/8/1
 */
public class DeleteException extends RuntimeException implements Serializable {

    /**
     * 异常状态码
     */
    private String code;

    public DeleteException() {
        super(BaseMessageConf.DELETE_DEFAULT_ERROR);
        this.code = ErrorCode.DELETE_DEFAULT_ERROR;
    }

    public DeleteException(String message, Throwable cause) {
        super(message, cause);
        this.code = ErrorCode.DELETE_DEFAULT_ERROR;
    }

    public DeleteException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public DeleteException(String message) {
        super(message);
        this.code = ErrorCode.DELETE_DEFAULT_ERROR;
    }

    public DeleteException(String code, String message) {
        super(message);
        this.code = code;
    }

    public DeleteException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
