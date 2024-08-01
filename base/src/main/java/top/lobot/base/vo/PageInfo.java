package top.lobot.base.vo;

import lombok.Data;

/**
 *
 * @author ykr
 * @date 2024/8/1
 */
@Data
public class PageInfo<T> {

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 当前页
     */
    private Long currentPage;

    /**
     * 页大小
     */
    private Long pageSize;
}
