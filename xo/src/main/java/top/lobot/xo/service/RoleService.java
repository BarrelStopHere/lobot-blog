package top.lobot.xo.service;


import top.lobot.base.service.SuperService;
import top.lobot.xo.entity.admin.Role;
import top.lobot.xo.vo.RoleVO;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
public interface RoleService extends SuperService<Role> {

    /**
     * 新增角色
     *
     * @param roleVO
     */
    public String addRole(RoleVO roleVO);

    /**
     * 编辑角色
     *
     * @param roleVO
     */
    public String editRole(RoleVO roleVO);

    /**
     * 删除角色
     *
     * @param roleVO
     */
    public String deleteRole(RoleVO roleVO);

}
