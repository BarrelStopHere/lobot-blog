package top.lobot.base.exception.exceptionType;

/**
 *
 * @author ykr
 * @date 2024/8/1
 */
public class ApiInvalidParamException extends RuntimeException {

    private static final long serialVersionUID = -4980934051246244713L;

    public ApiInvalidParamException() {
        super();
    }

    public ApiInvalidParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiInvalidParamException(String message) {
        super(message);
    }

    public ApiInvalidParamException(Throwable cause) {
        super(cause);
    }
}