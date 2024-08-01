package top.lobot.base.exception.exceptionType;

import top.lobot.base.conf.BaseMessageConf;
import top.lobot.base.conf.ErrorCode;

import java.io.Serializable;

/**
 *
 * @author ykr
 * @date 2024/8/1
 */
public class QueryException extends RuntimeException implements Serializable {

    /**
     * 异常状态码
     */
    private String code;

    public QueryException() {
        super(BaseMessageConf.QUERY_DEFAULT_ERROR);
        this.code = ErrorCode.QUERY_DEFAULT_ERROR;
    }

    public QueryException(String message, Throwable cause) {
        super(message, cause);
        this.code = ErrorCode.QUERY_DEFAULT_ERROR;
    }

    public QueryException(String message) {
        super(message);
        this.code = ErrorCode.QUERY_DEFAULT_ERROR;
    }

    public QueryException(String code, String message) {
        super(message);
        this.code = code;
    }

    public QueryException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
