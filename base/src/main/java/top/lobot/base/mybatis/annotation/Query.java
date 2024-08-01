package top.lobot.base.mybatis.annotation;

import top.lobot.base.mybatis.enums.QueryType;

import java.lang.annotation.*;

/**
 * 查询注解
 *
 * @author ykr
 * @date 2024/8/1
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Query {
    /**
     * 查询方式，默认为相等
     */
    QueryType value() default QueryType.EQ;

    /**
     * 属性名，如果当前属性名与 PO 不一致，可指定 PO 的属性名
     */
    String fieldName() default "";

    /**
     * 是否忽略查询，如果当前属性不需要查询，则可设置为 true
     */
    boolean ignore() default false;

    /**
     * 是否空查询，当为空时，是否依旧查询，默认不需要查询
     */
    boolean empty() default false;
}
