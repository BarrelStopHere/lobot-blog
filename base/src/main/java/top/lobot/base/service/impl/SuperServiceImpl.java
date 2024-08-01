package top.lobot.base.service.impl;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import top.lobot.base.mapper.SupperMapper;
import top.lobot.base.mybatis.page.vo.PageVO;
import top.lobot.base.service.SuperService;


/**
 *
 * @author ykr
 * @date 2024/8/1
 */
public class SuperServiceImpl<M extends SupperMapper<T>, T> extends ServiceImpl<M, T> implements SuperService<T> {

    @Autowired
    private M baseMapper;

    /**
     * 查询分页
     *
     * @param d             实体类参数对接
     * @param selectColumns 查询返回的列
     */
    @Override
    public <D> PageVO<T> page(D d, SFunction<T, ?>... selectColumns) {
        return baseMapper.selectPage(d, selectColumns);
    }

}
