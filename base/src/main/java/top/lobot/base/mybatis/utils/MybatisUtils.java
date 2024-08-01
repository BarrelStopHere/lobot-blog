package top.lobot.base.mybatis.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.lobot.base.mybatis.page.dto.PageDTO;
import top.lobot.base.mybatis.property.PageProperty;

/**
 * mybatis-plus最新分页方式
 *
 * @author ykr
 * @date 2024/8/1
 */
public class MybatisUtils {

    /**
     * 构建分页
     */
    public static <T> Page<T> buildPage(PageDTO pageDTO) {
        Long pageNum = null;
        Long pageSize = null;
        if (pageDTO != null) {
            pageNum = pageDTO.getCurrentPage();
            pageSize = pageDTO.getPageSize();
        }
        return buildPage(pageNum, pageSize);
    }

    /**
     * 构建分页
     */
    public static <T> Page<T> buildPage(Long pageNum, Long pageSize) {
        // 如果为空，则设置默认值
        if (pageNum == null) {
            pageNum = 1L;
        }
        if (pageSize == null) {
            pageSize = PageProperty.defaultPageSize;
        }

        // 如果超过最大分页数，则设置为最大分页数
        if (pageSize > PageProperty.maxPageSize) {
            pageSize = PageProperty.maxPageSize;
        }
        Page<T> page = new Page<>(pageNum, pageSize);
        return page;
    }

}
