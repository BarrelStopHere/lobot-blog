package top.lobot.base.exception;


import top.lobot.base.exception.exceptionType.BusinessException;
import top.lobot.base.response.ResponseResult;
import top.lobot.utils.StringUtils;

/**
 *
 * @author ykr
 * @date 2024/8/1
 */
public class ExceptionUtil {

    /**
     * 业务回滚，抛出特定异常：包含错误消息
     *
     * @param message
     */
    public static void rollback(String message) {
        throw new BusinessException(message);
    }

    /**
     * 业务回滚，抛出特定异常：包含错误消息，错误编码
     *
     * @param message
     * @param code
     */
    public static void rollback(String message, String code) {
        throw new BusinessException(message, code);
    }

    /**
     * 业务回滚，抛出特定异常：包含错误消息，错误原因
     *
     * @param message
     * @param cause
     */
    public static void rollback(String message, Throwable cause) {
        throw new BusinessException(message, cause);
    }

    /**
     * 业务回滚，抛出特定异常：包含错误消息，错误编码，错误原因
     *
     * @param message
     * @param code
     * @param cause
     */
    public static void rollback(String message, String code, Throwable cause) {
        throw new BusinessException(message, code, cause);
    }

    /**
     * 业务不需回滚，设置result返回
     *
     * @param message
     */
    public static ResponseResult setResult(String message) {
        return ResponseResult.fail(StringUtils.isBlank(message) ? "系统异常，请稍候..." : message);
    }
}
