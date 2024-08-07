package top.lobot.admin.restapi;


import top.lobot.admin.annotion.AuthorityVerify.AuthorityVerify;
import top.lobot.admin.annotion.AvoidRepeatableCommit.AvoidRepeatableCommit;
import top.lobot.admin.annotion.OperationLogger.OperationLogger;
import top.lobot.xo.entity.SysParams;
import top.lobot.utils.ResultUtil;
import top.lobot.xo.dto.SysParamsPageDTO;
import top.lobot.xo.service.SysParamsService;
import top.lobot.xo.vo.SysParamsVO;
import top.lobot.base.exception.ThrowableUtils;
import top.lobot.base.mybatis.page.vo.PageVO;
import top.lobot.base.validator.group.GetList;
import top.lobot.base.validator.group.Insert;
import top.lobot.base.validator.group.Update;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * @author ykr
 * @date 2024/8/7
 */
@RestController
@RequestMapping("/sysParams")
@Api(value = "参数配置相关接口", tags = {"参数配置相关接口"})
@Slf4j
public class SysParamsRestApi {

    @Autowired
    private SysParamsService sysParamsService;

    @AuthorityVerify
    @ApiOperation(value = "获取参数配置列表", notes = "获取参数配置列表", response = String.class)
    @PostMapping("/getList")
    public String getList(@Validated({GetList.class}) @RequestBody SysParamsPageDTO pageDTO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("获取参数配置列表");

        pageDTO.setOrderByDescColumn("sort,createTime");
        PageVO<SysParams> pageVO = sysParamsService.page(pageDTO);
        return ResultUtil.successWithData(pageVO);
    }

    @AvoidRepeatableCommit
    @AuthorityVerify
    @OperationLogger(value = "增加参数配置")
    @ApiOperation(value = "增加参数配置", notes = "增加参数配置", response = String.class)
    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody SysParamsVO sysParamsVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return sysParamsService.addSysParams(sysParamsVO);
    }

    @AuthorityVerify
    @OperationLogger(value = "编辑参数配置")
    @ApiOperation(value = "编辑参数配置", notes = "编辑参数配置", response = String.class)
    @PostMapping("/edit")
    public String edit(HttpServletRequest request, @Validated({Update.class}) @RequestBody SysParamsVO SysParamsVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        return sysParamsService.editSysParams(SysParamsVO);
    }

    @AuthorityVerify
    @OperationLogger(value = "批量删除参数配置")
    @ApiOperation(value = "批量删除参数配置", notes = "批量删除参数配置", response = String.class)
    @PostMapping("/deleteBatch")
    public String delete(@RequestBody List<SysParamsVO> SysParamsVoList, BindingResult result) {

        return sysParamsService.deleteBatchSysParams(SysParamsVoList);
    }
}

