package top.lobot.xo.vo;


import lombok.Data;
import top.lobot.base.vo.BaseVO;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
@Data
public class LinkVO extends BaseVO<LinkVO> {

    /**
     * 友链标题
     */
    private String title;
    /**
     * 友链介绍
     */
    private String summary;
    /**
     * 友链地址
     */
    private String url;

    /**
     * 友链状态： 0 申请中， 1：已上线，  2：已拒绝
     */
    private Integer linkStatus;

    /**
     * 排序字段
     */
    private Integer sort;

    /**
     * 站长邮箱
     */
    private String email;

    /**
     * 网站图标uid
     */
    private String fileUid;

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
    LinkVO() {

    }

}
