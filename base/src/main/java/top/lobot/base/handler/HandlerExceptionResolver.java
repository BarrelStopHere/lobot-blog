package top.lobot.base.handler;

import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ModelAndView;
import top.lobot.base.conf.BaseMessageConf;
import top.lobot.base.enums.ErrorCode;
import top.lobot.base.exception.exceptionType.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 全局异常处理
 *
 * @author ykr
 * @date 2024/8/1
 */
@Slf4j
public class HandlerExceptionResolver implements org.springframework.web.servlet.HandlerExceptionResolver {

    /**
     * 异常处理方法
     *
     * @param request
     * @param response
     * @param handler   出现异常的对象
     * @param exception 出现的异常信息
     * @return ModelAndView
     */
    @Override
    public ModelAndView resolveException(@NotNull HttpServletRequest request, HttpServletResponse response, Object handler, @NotNull Exception exception) {
        log.error("系统统一异常处理：", exception);
        // 若响应已响应或已关闭，则不操作
        if (response.isCommitted()) {
            return new ModelAndView();
        }

        // 组装错误提示信息
        String errorCode = ErrorCode.ERROR;
        String message = BaseMessageConf.OPERATION_FAIL;

        // 自定义业务相关异常
        if (exception instanceof BusinessException) {
            errorCode = ((BusinessException) exception).getCode();
            message = exception.getMessage();
        } else if (exception instanceof ApiInvalidParamException) {
            // 自定义参数校验相关的异常
            // 自动拼接异常信息
            errorCode = ErrorCode.PARAM_INCORRECT;
            message = exception.getMessage();
        } else if (exception instanceof LoginException) {
            // 自定义登录相关的异常
            errorCode = ((LoginException) exception).getCode();
            message = exception.getMessage();
        } else if (exception instanceof QueryException) {
            // 自定义查询相关的异常
            errorCode = ((QueryException) exception).getCode();
            message = exception.getMessage();
        } else if (exception instanceof UpdateException) {
            // 自定义更新操作相关的异常
            errorCode = ((UpdateException) exception).getCode();
            message = exception.getMessage();
        } else if (exception instanceof InsertException) {
            // 自定义新增操作相关的异常
            errorCode = ((InsertException) exception).getCode();
            message = exception.getMessage();
        } else if (exception instanceof DeleteException) {
            // 自定义删除操作相关的异常
            errorCode = ((DeleteException) exception).getCode();
            message = exception.getMessage();
        } else {
            // 其它异常
            message = exception.getMessage();
            log.error(exception.getMessage());
        }

        // 响应类型设置
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);

        // 响应结果输出
        try (PrintWriter writer = response.getWriter()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("code", errorCode);
            jsonObject.put("message", message);
            writer.write(jsonObject.toString());
        } catch (Exception e) {
            log.error("响应输出失败！原因如下：", e);
        }
        return new ModelAndView();
    }
}