package top.lobot.xo.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;
import top.lobot.base.vo.BaseVO;

/**
 * BlogVO
 *
 * @author: 陌溪
 * @create: 2019年12月4日12:26:36
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class TagVO extends BaseVO<TagVO> {

    /**
     * 标签内容
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

    /**
     * 无参构造方法，初始化默认值
     */
    TagVO() {

    }

}
