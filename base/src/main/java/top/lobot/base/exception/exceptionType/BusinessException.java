package top.lobot.base.exception.exceptionType;

/**
 *
 * @author ykr
 * @date 2024/8/1
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 4378279566155150808L;
    /**
     * 异常编码
     */
    private String code;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message, String code) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message, String code, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
