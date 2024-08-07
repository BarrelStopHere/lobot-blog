package top.lobot.admin.restapi;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ykr
 * @date 2024/8/7
 */
@RestController
@RequestMapping("/guest")
@Api(value = "游客相关接口", tags = {"游客相关接口"})
@Slf4j
public class GuestRestApi {

}

