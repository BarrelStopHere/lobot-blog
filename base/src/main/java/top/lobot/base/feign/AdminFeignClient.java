package top.lobot.base.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.lobot.base.conf.ig.feign.FeignConfiguration;

/**
 * 管理后台微服务
 *
 * @author ykr
 * @date 2024/8/2
 */
@FeignClient(name = "admin", configuration = FeignConfiguration.class)
public interface AdminFeignClient {


    /**
     * 获取系统配置信息
     */
    @RequestMapping(value = "/systemConfig/getSystemConfig", method = RequestMethod.GET)
    public String getSystemConfig();

}