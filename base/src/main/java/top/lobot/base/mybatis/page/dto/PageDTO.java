package top.lobot.base.mybatis.page.dto;

import lombok.Data;
import top.lobot.base.mybatis.annotation.Query;

import java.io.Serializable;

/**
 * 分页DTO
 *
 * @author ykr
 * @date 2024/8/1
 */
@Data
public class PageDTO implements Serializable {
    private static final long serialVersionUID = 6820795168109330046L;

    /**
     * 每页显示记录数
     */
    @Query(ignore = true)
    private Long pageSize;

    /**
     * 起始页
     */
    @Query(ignore = true)
    private Long currentPage;

    /**
     * OrderBy排序字段（desc: 降序）
     */
    @Query(ignore = true)
    private String orderByDescColumn;

    /**
     * OrderBy排序字段（asc: 升序）
     */
    @Query(ignore = true)
    private String orderByAscColumn;
}
