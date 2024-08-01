package top.lobot.base.mybatis.reflect;

/**
 *
 * @author ykr
 * @date 2024/8/1
 */
public class GenericTypeUtils {

    private static IGenericTypeResolver GENERIC_TYPE_RESOLVER;

    public GenericTypeUtils() {
    }

    public static Class<?>[] resolveTypeArguments(final Class<?> clazz, final Class<?> genericIfc) {
        return null == GENERIC_TYPE_RESOLVER ? SpringReflectionHelper.resolveTypeArguments(clazz, genericIfc) : GENERIC_TYPE_RESOLVER.resolveTypeArguments(clazz, genericIfc);
    }

    public static void setGenericTypeResolver(IGenericTypeResolver genericTypeResolver) {
        GENERIC_TYPE_RESOLVER = genericTypeResolver;
    }

}
