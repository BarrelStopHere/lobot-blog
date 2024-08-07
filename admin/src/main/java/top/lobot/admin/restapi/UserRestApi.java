package top.lobot.admin.restapi;


import top.lobot.admin.annotion.AuthorityVerify.AuthorityVerify;
import top.lobot.admin.annotion.OperationLogger.OperationLogger;
import top.lobot.utils.ResultUtil;
import top.lobot.xo.service.UserService;
import top.lobot.xo.vo.UserVO;
import top.lobot.base.exception.ThrowableUtils;
import top.lobot.base.validator.group.Delete;
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

/**
 *
 * @author ykr
 * @date 2024/8/7
 */
@RestController
@Api(value = "用户相关接口", tags = {"用户相关接口"})
@RequestMapping("/user")
@Slf4j
public class UserRestApi {

    @Autowired
    private UserService userService;

    @AuthorityVerify
    @ApiOperation(value = "获取用户列表", notes = "获取用户列表", response = String.class)
    @PostMapping("/getList")
    public String getList(@Validated({GetList.class}) @RequestBody UserVO userVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("获取用户列表: {}", userVO);
        return ResultUtil.successWithData(userService.getPageList(userVO));
    }

    @AuthorityVerify
    @OperationLogger(value = "新增用户")
    @ApiOperation(value = "新增用户", notes = "新增用户", response = String.class)
    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody UserVO userVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("新增用户: {}", userVO);
        return userService.addUser(userVO);
    }

    @AuthorityVerify
    @OperationLogger(value = "编辑用户")
    @ApiOperation(value = "编辑用户", notes = "编辑用户", response = String.class)
    @PostMapping("/edit")
    public String edit(@Validated({Update.class}) @RequestBody UserVO userVO, BindingResult result) {
        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("编辑用户: {}", userVO);
        return userService.editUser(userVO);
    }

    @AuthorityVerify
    @OperationLogger(value = "删除用户")
    @ApiOperation(value = "删除用户", notes = "删除用户", response = String.class)
    @PostMapping("/delete")
    public String delete(@Validated({Delete.class}) @RequestBody UserVO userVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("删除用户: {}", userVO);
        return userService.deleteUser(userVO);
    }

    @AuthorityVerify
    @OperationLogger(value = "重置用户密码")
    @ApiOperation(value = "重置用户密码", notes = "重置用户密码", response = String.class)
    @PostMapping("/resetUserPassword")
    public String resetUserPassword(@Validated({Delete.class}) @RequestBody UserVO userVO, BindingResult result) {

        // 参数校验
        ThrowableUtils.checkParamArgument(result);
        log.info("重置用户密码: {}", userVO);
        return userService.resetUserPassword(userVO);
    }
}