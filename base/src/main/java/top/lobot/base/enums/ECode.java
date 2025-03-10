package top.lobot.base.enums;

/**
 *
 * @author ykr
 * @date 2024/8/1
 */
public class ECode {

    /**
     * 操作成功
     */
    public static final Integer SUCCESS = 200;

    /**
     * 操作失败，请求参数有误
     */
    public static final Integer ERROR = 400;

    /**
     * 未通过token验证
     */
    public static final Integer UNAUTHORIZED = 401;

    /**
     * 无操作权限
     */
    public static final Integer NO_OPERATION_AUTHORITY = 402;

    /**
     * 服务器出现异常
     */
    public static final Integer SERVER_ERROR = 500;

    /**
     * 请求次数过于频繁
     */
    public static final Integer REQUEST_OVER_LIMIT = 502;
}
