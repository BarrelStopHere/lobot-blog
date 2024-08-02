package top.lobot.xo.dto;

import lombok.Data;
import top.lobot.base.mybatis.annotation.Query;
import top.lobot.base.mybatis.enums.QueryType;
import top.lobot.base.mybatis.page.dto.PageDTO;
import top.lobot.xo.conf.SQLConf;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
@Data
public class LinkPageDTO extends PageDTO {

    /**
     * 友链标题
     */
    @Query(value = QueryType.LIKE, fieldName = SQLConf.TITLE)
    private String keyword;

    /**
     * 友链状态： 0 申请中， 1：已上线，  2：已拒绝
     */
    private Integer linkStatus;

}
