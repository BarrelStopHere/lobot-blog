package top.lobot.base.mybatis.reflect;

import org.springframework.core.GenericTypeResolver;

/**
 *
 * @author ykr
 * @date 2024/8/1
 */
public class SpringReflectionHelper {

    public SpringReflectionHelper() {
    }

    public static Class<?>[] resolveTypeArguments(Class<?> clazz, Class<?> genericIfc) {
        return GenericTypeResolver.resolveTypeArguments(clazz, genericIfc);
    }

}
