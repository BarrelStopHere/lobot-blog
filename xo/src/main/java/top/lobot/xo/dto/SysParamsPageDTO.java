package top.lobot.xo.dto;

import lombok.Data;
import top.lobot.base.mybatis.annotation.Query;
import top.lobot.base.mybatis.enums.QueryType;
import top.lobot.base.mybatis.page.dto.PageDTO;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
@Data
public class SysParamsPageDTO extends PageDTO {

    /**
     * 参数名称
     */
    @Query(QueryType.LIKE)
    private String paramsName;

    /**
     * 参数键名
     */
    @Query(QueryType.LIKE)
    private String paramsKey;
}
