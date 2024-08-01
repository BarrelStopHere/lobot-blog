package top.lobot.base.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import top.lobot.base.response.ResponseResult;
import top.lobot.base.result.ResultCode;

/**
 * 参数校验
 *
 * @author ykr
 * @date 2024/8/1
 */
@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

    /**
     * 400错误
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseBody
    public ResponseResult requestNotReadable(HttpMessageNotReadableException ex) {
        log.error("异常类 HttpMessageNotReadableException {},", ex.getMessage());
        return ResponseResult.fail(ResultCode.VALIDATE_FAILED.getCode(),"参数异常");
    }

    /**
     * 400错误
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({TypeMismatchException.class})
    @ResponseBody
    public ResponseResult requestTypeMismatch(TypeMismatchException ex) {
        log.error("异常类 TypeMismatchException {},", ex.getMessage());
        return ResponseResult.fail(ResultCode.VALIDATE_FAILED.getCode(),"参数异常");
    }

    /**
     * 400错误
     *
     * @param ex
     * @return
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseBody
    public ResponseResult requestMissingServletRequest(MissingServletRequestParameterException ex) {
        log.error("异常类 MissingServletRequestParameterException {},", ex.getMessage());
        return ResponseResult.fail(ResultCode.VALIDATE_FAILED.getCode(),"参数异常");
    }

    /**
     * 405错误
     *
     * @return
     */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    @ResponseBody
    public ResponseResult request405() {
        log.error("异常类 HttpRequestMethodNotSupportedException ");
        return ResponseResult.fail(ResultCode.VALIDATE_FAILED.getCode(),"参数异常");
    }

    /**
     * 415错误
     *
     * @return
     */
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    @ResponseBody
    public ResponseResult request415(HttpMediaTypeNotSupportedException ex) {
        log.error("异常类 HttpMediaTypeNotSupportedException {}", ex.getMessage());
        return ResponseResult.fail(ResultCode.VALIDATE_FAILED.getCode(),"参数异常");
    }
}
