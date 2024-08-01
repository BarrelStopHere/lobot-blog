package top.lobot.base.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ClassUtils;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import org.apache.ibatis.annotations.Param;
import top.lobot.base.mybatis.page.dto.PageDTO;
import top.lobot.base.mybatis.page.vo.PageVO;
import top.lobot.base.mybatis.query.QueryWrapperPlus;
import top.lobot.base.mybatis.reflect.GenericTypeUtils;
import top.lobot.base.mybatis.utils.MybatisUtils;

import java.util.List;

/**
 * BaseMapper增强
 *
 * @author ykr
 * @date 2024/8/1
 */
public interface SupperMapper<T> extends BaseMapper<T> {
    default PageVO<T> selectPage(PageDTO pageDTO, @Param("ew") Wrapper<T> queryWrapper) {
        // MyBatis Plus 分页查询
        IPage<T> myBatisPage = MybatisUtils.buildPage(pageDTO);
        selectPage(myBatisPage, queryWrapper);
        // 转换返回值
        return new PageVO<>(myBatisPage.getRecords(), myBatisPage.getTotal(), myBatisPage.getSize());
    }

    /**
     * 查询分页
     *
     * @param d             实体类参数对接
     * @param selectColumns 查询返回的列
     */
    default <D> PageVO<T> selectPage(D d, SFunction<T, ?>... selectColumns) {
        // 构造分页，不能强制转 pageDTO，否则如果没有继承的话，会报错
        PageDTO pageDTO = d instanceof PageDTO ? (PageDTO) d : null;
        IPage<T> myBatisPage = MybatisUtils.buildPage(pageDTO);
        // 查询数据
        selectPage(myBatisPage, buildQueryWrapper(d, selectColumns));
        // 转换返回值
        return new PageVO<>(myBatisPage.getRecords(), myBatisPage.getTotal(), myBatisPage.getSize());
    }

    /**
     * 查询列表
     *
     * @param d             实体类参数对接
     * @param selectColumns 查询返回的列
     */
    default <D> List<T> selectList(D d, SFunction<T, ?>... selectColumns) {
        return selectList(buildQueryWrapper(d, selectColumns));
    }

    /**
     * 查询单条
     *
     * @param d 实体类参数对接
     */
    default <D> T selectOne(D d) {
        return selectOne(buildQueryWrapper(d));
    }

    /**
     * 查询总记录数
     *
     * @param d 实体类参数对接
     */
    default <D> Long selectCount(D d) {
        return selectCount(buildQueryWrapper(d)).longValue();
    }

    /**
     * 构建 Wrapper 查询条件
     *
     * @param d             DTO 实体参数对象
     * @param selectColumns 查询返回的列
     * @return 查询构造器
     */
    default <D> QueryWrapperPlus<T> buildQueryWrapper(D d, SFunction<T, ?>... selectColumns) {
        Class<?>[] typeArguments = GenericTypeUtils.resolveTypeArguments(ClassUtils.getUserClass(this.getClass()), SupperMapper.class);
        Class<T> entityClass =  null == typeArguments ? null : (Class<T>) typeArguments[0];
        return new QueryWrapperPlus<T>().buildQueryWrapper(entityClass, d, selectColumns);
    }

}
