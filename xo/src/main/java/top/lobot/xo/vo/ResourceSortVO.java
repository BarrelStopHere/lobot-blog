package top.lobot.xo.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import top.lobot.base.vo.BaseVO;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
@EqualsAndHashCode(callSuper = true)
@ToString
@Data
public class ResourceSortVO extends BaseVO<ResourceSortVO> {

    /**
     * 分类名
     */
    private String sortName;
    /**
     * 分类介绍
     */
    private String content;

    /**
     * 分类图片UID
     */
    private String fileUid;

    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * 无参构造方法
     */
    ResourceSortVO() {

    }

}
