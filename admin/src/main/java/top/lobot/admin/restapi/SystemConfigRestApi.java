package top.lobot.admin.restapi;


import com.google.common.collect.Lists;
import top.lobot.admin.annotion.AuthorityVerify.AuthorityVerify;
import top.lobot.admin.annotion.OperationLogger.OperationLogger;
import top.lobot.utils.ResultUtil;
import top.lobot.xo.service.SystemConfigService;
import top.lobot.xo.vo.SystemConfigVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author ykr
 * @date 2024/8/7
 */
@Api(value = "系统配置相关接口", tags = {"系统配置相关接口"})
@RestController
@RequestMapping("/systemConfig")
@Slf4j
public class SystemConfigRestApi {

    @Autowired
    private SystemConfigService systemConfigService;

    @AuthorityVerify
    @ApiOperation(value = "获取系统配置", notes = "获取系统配置")
    @GetMapping("/getSystemConfig")
    public String getSystemConfig() {
        return ResultUtil.successWithData(systemConfigService.getConfig());
    }

    @AuthorityVerify
    @ApiOperation(value = "通过Key前缀清空Redis缓存", notes = "通过Key前缀清空Redis缓存")
    @PostMapping("/cleanRedisByKey")
    public String cleanRedisByKey(@RequestBody List<String> key) {
        return systemConfigService.cleanRedisByKey(key);
    }

    @ApiOperation(value = "通过url快速清空Redis缓存", notes = "通过url快速清空Redis缓存")
    @GetMapping("/remove/{key}")
    public String cleanRedisByKey(@PathVariable String key) {
        return systemConfigService.cleanRedisByKey(Lists.newArrayList(key));
    }

    @AuthorityVerify
    @OperationLogger(value = "修改系统配置")
    @ApiOperation(value = "修改系统配置", notes = "修改系统配置")
    @PostMapping("/editSystemConfig")
    public String editSystemConfig(@RequestBody SystemConfigVO systemConfigVO) {
        return systemConfigService.editSystemConfig(systemConfigVO);
    }
}

