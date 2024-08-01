package top.lobot.base.mybatis.reflect;

/**
 *
 * @author ykr
 * @date 2024/8/1
 */
public interface IGenericTypeResolver {

    Class<?>[] resolveTypeArguments(final Class<?> clazz, final Class<?> genericIfc);

}
