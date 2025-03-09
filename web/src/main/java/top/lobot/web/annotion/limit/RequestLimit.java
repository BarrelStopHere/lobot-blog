package top.lobot.web.annotion.limit;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/*
 * @Description: 限流 
 * @Author: ykr
 * @date:  2025/2/16 16:29
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface RequestLimit {

    /**
     * 允许访问的次数，默认值100
     */
    int amount() default 100;

    /**
     * 时间段，单位为毫秒，默认值一分钟
     */
    long time() default 60000;
}