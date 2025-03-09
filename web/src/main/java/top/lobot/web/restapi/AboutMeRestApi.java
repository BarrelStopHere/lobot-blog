package top.lobot.web.restapi;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lobot.base.enums.EBehavior;
import top.lobot.utils.ResultUtil;
import top.lobot.web.annotion.log.BussinessLog;
import top.lobot.web.global.SysConf;
import top.lobot.xo.service.AdminService;
import top.lobot.xo.service.WebConfigService;

/*
 * @Description: 关于我 
 * @Author: ykr
 * @date:  2025/2/16 16:14
 */
@RestController
@RequestMapping("/about")
@Api(value = "关于我相关接口", tags = {"关于我相关接口"})
@Slf4j
public class AboutMeRestApi {

    @Autowired
    AdminService adminService;

    @Autowired
    WebConfigService webConfigService;

    /**
     * 获取关于我的信息
     */
    @BussinessLog(value = "关于我", behavior = EBehavior.VISIT_PAGE)
    @ApiOperation(value = "关于我", notes = "关于我")
    @GetMapping("/getMe")
    public String getMe() {
        log.info("获取关于我的信息");
        return ResultUtil.result(SysConf.SUCCESS, adminService.getAdminByUser(SysConf.ADMIN));
    }

    @ApiOperation(value = "获取联系方式", notes = "获取联系方式")
    @GetMapping("/getContact")
    public String getContact() {
        log.info("获取联系方式");
        return ResultUtil.result(SysConf.SUCCESS, webConfigService.getWebConfigByShowList());
    }

}

