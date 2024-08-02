package top.lobot.xo.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lobot.base.vo.BaseVO;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BlogSortVO extends BaseVO<BlogSortVO> {

    /**
     * 分类名
     */
    private String sortName;

    /**
     * 分类介绍
     */
    private String content;

    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * OrderBy排序字段（desc: 降序）
     */
    private String orderByDescColumn;

    /**
     * OrderBy排序字段（asc: 升序）
     */
    private String orderByAscColumn;
}
