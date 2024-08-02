package top.lobot.xo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lobot.base.entity.BaseEntity;

/**
 * 操作日志异常
 *
 * @author ykr
 * @date 2024/8/2
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("exception_log")
public class ExceptionLog extends BaseEntity<ExceptionLog> {

    private static final long serialVersionUID = -4851055162892178225L;

    /**
     * 操作IP
     */
    private String ip;

    /**
     * ip来源
     */
    private String ipSource;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 描述
     */
    private String operation;

    /**
     * 参数
     */
    private String params;

    /**
     * 异常对象json格式
     */
    private String exceptionJson;

    /**
     * 异常简单信息,等同于e.getMessage
     */
    private String exceptionMessage;
}
