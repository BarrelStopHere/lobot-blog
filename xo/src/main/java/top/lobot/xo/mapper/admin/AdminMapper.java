package top.lobot.xo.mapper.admin;

import org.apache.ibatis.annotations.Param;
import top.lobot.base.mapper.SuperMapper;
import top.lobot.xo.entity.Admin;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
public interface AdminMapper extends SuperMapper<Admin> {

    /**
     * 通过uid获取管理员
     *
     * @return
     */
    public Admin getAdminByUid(@Param("uid") String uid);
}
