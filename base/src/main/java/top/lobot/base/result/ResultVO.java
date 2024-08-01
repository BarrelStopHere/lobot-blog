package top.lobot.base.result;

import lombok.Getter;

/**
 *
 * @author ykr
 * @date 2024/8/1
 */
@Getter
public class ResultVO<T> {

    /**
     * 状态码，比如 200 代表响应成功
     */
    private Integer code;

    /**
     * 响应信息，用来说明响应情况
     */
    private String message;

    /**
     * 响应的具体数据
     */
    private T data;

    public ResultVO() {

    }

    public ResultVO(T data) {
        this(ResultCode.SUCCESS, data);
    }

    public ResultVO(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMsg();
        this.data = data;
    }

    public ResultVO(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    /**
     * 请求处理成功且不需要返回数据时使用的工具方法
     *
     * @return
     */
    public static <Type> ResultVO<Type> successWithoutData() {
        return successWithData(null);
    }

    /**
     * 请求处理成功且需要返回数据时使用的工具方法
     *
     * @param data 要返回的数据
     * @return
     */
    public static <Type> ResultVO<Type> successWithData(Type data) {
        return new ResultVO<Type>(ResultCode.SUCCESS, data);
    }

    public static ResultVO successWithMsg(String message) {
        return new ResultVO(ResultCode.SUCCESS.getCode(), message);
    }

    public static ResultVO failedWithMsg(String message) {
        return new ResultVO(ResultCode.FAILED.getCode(), message);
    }

    /**
     * 请求处理失败后使用的工具方法
     *
     * @return
     */
    public static <Type> ResultVO<Type> failed() {
        return new ResultVO<Type>(ResultCode.FAILED, null);
    }

    /**
     * 请求处理失败后使用的工具方法
     *
     * @param resultCode
     * @param <Type>
     * @return
     */
    public static <Type> ResultVO<Type> failed(ResultCode resultCode) {
        return new ResultVO<Type>(resultCode, null);
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "code=" + code +
                ", msg='" + message + '\'' +
                ", data=" + data +
                '}';
    }

}
