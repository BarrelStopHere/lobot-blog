package top.lobot.base.mybatis.query;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

import org.springframework.util.CollectionUtils;
import top.lobot.utils.StringUtils;

import java.util.Collection;

/**
 *
 * @author ykr
 * @date 2024/8/1
 */
public class LambdaQueryWrapperPlus<T> extends LambdaQueryWrapper<T> {

    /**
     * 模糊查询
     */
    public LambdaQueryWrapperPlus<T> likeIf(SFunction<T, ?> column, String value) {
        return StringUtils.isBlank(value) ? this : like(column, value);
    }

    @Override
    public LambdaQueryWrapperPlus<T> like(SFunction<T, ?> column, Object value) {
        return (LambdaQueryWrapperPlus) super.like(column, value);
    }

    /**
     * 相等
     */
    public LambdaQueryWrapperPlus<T> eqIf(SFunction<T, ?> column, Object value) {
        return StringUtils.isNullBlank(value) ? this : eq(column, value);
    }

    @Override
    public LambdaQueryWrapperPlus<T> eq(SFunction<T, ?> column, Object value) {
        return (LambdaQueryWrapperPlus) super.eq(column, value);
    }

    /**
     * 包含
     */
    public LambdaQueryWrapperPlus<T> inIf(SFunction<T, ?> column, Collection<?> values) {
        return CollectionUtils.isEmpty(values) ? this : in(column, values);
    }

    @Override
    public LambdaQueryWrapperPlus<T> in(SFunction<T, ?> column, Collection<?> values) {
        return (LambdaQueryWrapperPlus) super.in(column, values);
    }

    /**
     * 不包含
     */
    public LambdaQueryWrapperPlus<T> notInIf(SFunction<T, ?> column, Collection<?> values) {
        return CollectionUtils.isEmpty(values) ? this : notIn(column, values);
    }

    @Override
    public LambdaQueryWrapperPlus<T> notIn(SFunction<T, ?> column, Collection<?> values) {
        return (LambdaQueryWrapperPlus) super.notIn(column, values);
    }

    /**
     * 小于
     */
    public LambdaQueryWrapperPlus<T> ltIf(SFunction<T, ?> column, Object value) {
        return StringUtils.isNullBlank(value) ? this : lt(column, value);
    }

    @Override
    public LambdaQueryWrapperPlus<T> lt(SFunction<T, ?> column, Object value) {
        return (LambdaQueryWrapperPlus) super.lt(column, value);
    }

    /**
     * 小于等于
     */
    public LambdaQueryWrapperPlus<T> leIf(SFunction<T, ?> column, Object value) {
        return StringUtils.isNullBlank(value) ? this : le(column, value);
    }

    @Override
    public LambdaQueryWrapperPlus<T> le(SFunction<T, ?> column, Object value) {
        return (LambdaQueryWrapperPlus) super.le(column, value);
    }

    /**
     * 大于
     */
    public LambdaQueryWrapperPlus<T> gtIf(SFunction<T, ?> column, Object value) {
        return StringUtils.isNullBlank(value) ? this : gt(column, value);
    }

    @Override
    public LambdaQueryWrapperPlus<T> gt(SFunction<T, ?> column, Object value) {
        return (LambdaQueryWrapperPlus) super.gt(column, value);
    }

    /**
     * 大于等于
     */
    public LambdaQueryWrapperPlus<T> geIf(SFunction<T, ?> column, Object value) {
        return StringUtils.isNullBlank(value) ? this : ge(column, value);
    }

    @Override
    public LambdaQueryWrapperPlus<T> ge(SFunction<T, ?> column, Object value) {
        return (LambdaQueryWrapperPlus) super.ge(column, value);
    }

}
