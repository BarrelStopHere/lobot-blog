package top.lobot.admin.annotion.AuthorityVerify;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.gson.internal.LinkedTreeMap;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.lobot.admin.global.MessageConf;
import top.lobot.admin.global.SQLConf;
import top.lobot.base.enums.ECode;
import top.lobot.base.config.jwt.Audience;
import top.lobot.base.config.jwt.JwtTokenUtil;
import top.lobot.base.enums.EMenuType;
import top.lobot.base.enums.EStatus;
import top.lobot.utils.*;
import top.lobot.xo.conf.RedisConf;
import top.lobot.xo.conf.SysConf;
import top.lobot.xo.entity.Admin;
import top.lobot.xo.entity.CategoryMenu;
import top.lobot.xo.entity.Role;
import top.lobot.xo.service.AdminService;
import top.lobot.xo.service.CategoryMenuService;
import top.lobot.xo.service.RoleService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 权限切面实现
 *
 * @author ykr
 * @date 2024/8/2
 */
@Aspect
@Component
@Slf4j
public class AuthorityVerifyAspect {
    @Autowired
    CategoryMenuService categoryMenuService;

    @Autowired
    RoleService roleService;

    @Autowired
    AdminService adminService;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private Audience audience;

    @Value(value = "${tokenHead}")
    private String tokenHead;

    @Pointcut(value = "@annotation(authorityVerify)")
    public void pointcut(AuthorityVerify authorityVerify) {

    }

    @Around(value = "pointcut(authorityVerify)")
    public Object doAround(ProceedingJoinPoint joinPoint, AuthorityVerify authorityVerify) throws Throwable {

        ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attribute.getRequest();

        //获取请求路径
        String url = request.getRequestURI();

        // 解析出请求者的ID和用户名
        String adminUid = jwtTokenUtil.getUserUid(CookieUtils.getCookieValue(request, SysConf.ADMIN_TOKEN).substring(tokenHead.length()), audience.getBase64Secret());

        // 管理员能够访问的路径
        String visitUrlStr = redisUtil.get(RedisConf.ADMIN_VISIT_MENU + RedisConf.SEGMENTATION + adminUid);

        LinkedTreeMap<String, String> visitMap = new LinkedTreeMap<>();

        if (StringUtils.isNotEmpty(visitUrlStr) && !visitUrlStr.equals("{}")) {
            // 从Redis中获取
            visitMap = (LinkedTreeMap<String, String>) JsonUtils.jsonToMap(visitUrlStr, String.class);
        } else {
            // 查询数据库获取
            Admin admin = adminService.getById(adminUid);

            String roleUid = admin.getRoleUid();

            Role role = roleService.getById(roleUid);

            String categoryMenuUidStr = role.getCategoryMenuUids();

            List<String> categoryMenuUids = JSONArray.parseArray(categoryMenuUidStr.replace("\\\"", "\""),String.class);

            // 这里只需要查询访问的按钮
            QueryWrapper<CategoryMenu> queryWrapper = new QueryWrapper<>();
            queryWrapper.in(SQLConf.UID, categoryMenuUids);
            queryWrapper.eq(SQLConf.MENU_TYPE, EMenuType.BUTTON);
            queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
            List<CategoryMenu> buttonList = categoryMenuService.list(queryWrapper);

            for (CategoryMenu item : buttonList) {
                if (StringUtils.isNotEmpty(item.getUrl())) {
                    visitMap.put(item.getUrl(), item.getUrl());
                }
            }
            // 将访问URL存储到Redis中
            redisUtil.setEx(RedisConf.ADMIN_VISIT_MENU + SysConf.REDIS_SEGMENTATION + adminUid, JsonUtils.objectToJson(visitMap), 1, TimeUnit.HOURS);
        }

        // 判断该角色是否能够访问该接口
        if (visitMap.get(url) != null) {
            log.info("用户拥有操作权限，访问的路径: {}，拥有的权限接口：{}", url, visitMap.get(url));
            //执行业务
            return joinPoint.proceed();
        } else {
            log.info("用户不具有操作权限，访问的路径: {}", url);
            return ResultUtil.result(ECode.NO_OPERATION_AUTHORITY, MessageConf.RESTAPI_NO_PRIVILEGE);
        }
    }

}
