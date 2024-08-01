package top.lobot.base.mybatis.page.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分页VO
 *
 * @author ykr
 * @date 2024/8/1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVO<T> implements Serializable {

    private static final Long serialVersionUID = 1L;

    /**
     * 数据列表
     */
    private List<T> records;

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 每页显示记录数
     */
    private Long size;

}
