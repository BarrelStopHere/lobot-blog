package top.lobot.base.service;

import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.service.IService;
import top.lobot.base.mybatis.page.vo.PageVO;
import top.lobot.base.mybatis.query.QueryWrapperPlus;

import java.util.List;

/**
 * 增强IService
 *
 * @author ykr
 * @date 2024/8/1
 */
public interface SuperService<T> extends IService<T> {

    /**
     * 查询分页
     *
     * @param d             实体类参数对接
     * @param selectColumns 查询返回的列
     */
    <D> PageVO<T> page(D d, SFunction<T, ?>... selectColumns);

    /**
     * 查询列表
     *
     * @param d             实体类参数对接
     * @param selectColumns 查询返回的列
     */
    default <D> List<T> list(D d, SFunction<T, ?>... selectColumns) {
        return list(buildQueryWrapper(d, selectColumns));
    }

    /**
     * 查询单条
     *
     * @param d 实体类参数对接
     */
    default <D> T getOne(D d) {
        return getOne(buildQueryWrapper(d));
    }

    /**
     * 查询单条
     *
     * @param d       实体类参数对接
     * @param throwEx 有多个结果是否抛出异常
     */
    default <D> T getOne(D d, boolean throwEx) {
        return getOne(buildQueryWrapper( d), throwEx);
    }

    /**
     * 查询总记录数
     *
     * @param d 实体类参数对接
     */
    default <D> Long count(D d) {
        return (long) count(buildQueryWrapper(d));
    }

    /**
     * 构建 Wrapper 查询条件
     *
     * @param d             DTO 实体参数对象
     * @param selectColumns 查询返回的列
     * @return 查询构造器
     */
    default <D> QueryWrapperPlus<T> buildQueryWrapper(D d, SFunction<T, ?>... selectColumns) {
        return new QueryWrapperPlus<T>().buildQueryWrapper(getEntityClass(), d, selectColumns);
    }

    /**
     * 获取当前T 类型 Class
     *
     * @return
     */
    default Class<T> getEntityClass() {
        return (Class<T>) ReflectionKit.getSuperClassGenericType(this.getClass(), 1);
    }

}
