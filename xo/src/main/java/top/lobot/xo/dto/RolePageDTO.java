package top.lobot.xo.dto;

import lombok.Data;
import top.lobot.base.mybatis.annotation.Query;
import top.lobot.base.mybatis.enums.QueryType;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
@Data
public class RolePageDTO {

    /**
     * 角色名称
     */
    @Query(value = QueryType.LIKE, fieldName = "roleName")
    private String keyword;

    /**
     * 角色状态
     */
    private Integer status;

}
