package top.lobot.xo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import top.lobot.xo.entity.admin.Admin;
import top.lobot.xo.entity.admin.Role;
import top.lobot.utils.RedisUtil;
import top.lobot.utils.ResultUtil;
import top.lobot.xo.conf.MessageConf;
import top.lobot.xo.conf.RedisConf;
import top.lobot.xo.conf.SQLConf;
import top.lobot.xo.conf.SysConf;
import top.lobot.xo.mapper.RoleMapper;
import top.lobot.xo.service.AdminService;
import top.lobot.xo.service.RoleService;
import top.lobot.xo.vo.RoleVO;
import top.lobot.base.enums.EStatus;
import top.lobot.base.service.impl.SuperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Set;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
@Service
public class RoleServiceImpl extends SuperServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AdminService adminService;

    @Override
    public String addRole(RoleVO roleVO) {
        String roleName = roleVO.getRoleName();
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.ROLENAEM, roleName);
        Role getRole = roleService.getOne(queryWrapper);
        if (getRole == null) {
            Role role = new Role();
            role.setRoleName(roleVO.getRoleName());
            role.setCategoryMenuUids(roleVO.getCategoryMenuUids());
            role.setSummary(roleVO.getSummary());
            role.insert();
            return ResultUtil.result(SysConf.SUCCESS, MessageConf.INSERT_SUCCESS);
        }
        return ResultUtil.errorWithMessage(MessageConf.ENTITY_EXIST);
    }

    @Override
    public String editRole(RoleVO roleVO) {
        String uid = roleVO.getUid();
        Role getRole = roleService.getById(uid);
        if (getRole == null) {
            return ResultUtil.errorWithMessage(MessageConf.PARAM_INCORRECT);
        }
        getRole.setRoleName(roleVO.getRoleName());
        getRole.setCategoryMenuUids(roleVO.getCategoryMenuUids());
        getRole.setSummary(roleVO.getSummary());
        getRole.setUpdateTime(new Date());
        getRole.updateById();
        // 修改成功后，需要删除redis中所有的admin访问路径
        deleteAdminVisitUrl();
        return ResultUtil.successWithMessage(MessageConf.UPDATE_SUCCESS);
    }

    @Override
    public String deleteRole(RoleVO roleVO) {
        // 判断该角色下是否绑定了管理员
        QueryWrapper<Admin> blogQueryWrapper = new QueryWrapper<>();
        blogQueryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        blogQueryWrapper.in(SQLConf.ROLEUID, roleVO.getUid());
        Integer adminCount = adminService.count(blogQueryWrapper);
        if (adminCount > 0) {
            return ResultUtil.errorWithMessage(MessageConf.ADMIN_UNDER_THIS_ROLE);
        }
        Role role = roleService.getById(roleVO.getUid());
        role.setStatus(EStatus.DISABLED);
        role.setUpdateTime(new Date());
        role.updateById();
        deleteAdminVisitUrl();
        return ResultUtil.successWithMessage(MessageConf.DELETE_SUCCESS);
    }


    /**
     * 删除Redis中管理员的访问路径
     */
    private void deleteAdminVisitUrl() {
        Set<String> keys = redisUtil.keys(RedisConf.ADMIN_VISIT_MENU + "*");
        redisUtil.delete(keys);
    }
}
