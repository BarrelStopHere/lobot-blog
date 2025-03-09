package top.lobot.web.restapi;

import top.lobot.utils.ResultUtil;
import top.lobot.web.global.SysConf;
import top.lobot.xo.service.SubjectItemService;
import top.lobot.xo.service.SubjectService;
import top.lobot.xo.vo.SubjectItemVO;
import top.lobot.xo.vo.SubjectVO;
import top.lobot.base.exception.ThrowableUtils;
import top.lobot.base.validator.group.GetList;
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

/*
 * @Description: 专题
 * @Author: ykr
 * @date:  2025/2/16 17:23
 */
@Api(value = "专题相关接口", tags = {"专题相关接口"})
@RestController
@RequestMapping("/subject")
@Slf4j
public class SubjectRestApi {

    @Autowired
    SubjectService subjectService;

    @Autowired
    SubjectItemService subjectItemService;

    @ApiOperation(value = "获取专题列表", notes = "获取专题列表", response = String.class)
    @PostMapping("/getList")
    public String getList(@Validated({GetList.class}) @RequestBody SubjectVO subjectVO, BindingResult result) {

        ThrowableUtils.checkParamArgument(result);
        return ResultUtil.result(SysConf.SUCCESS, subjectService.getPageList(subjectVO));
    }

    @ApiOperation(value = "获取专题Item列表", notes = "获取专题Item列表", response = String.class)
    @PostMapping("/getItemList")
    public String getItemList(@Validated({GetList.class}) @RequestBody SubjectItemVO subjectItemVO, BindingResult result) {

        ThrowableUtils.checkParamArgument(result);
        return ResultUtil.result(SysConf.SUCCESS, subjectItemService.getPageList(subjectItemVO));
    }

}

