package top.lobot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.oas.annotations.EnableOpenApi;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/*
 * @Description: 扫包需要注意顺序 
 * @Author: ykr
 * @date:  2025/2/21 17:09
 */
@EnableScheduling
@EnableTransactionManagement
@SpringBootApplication
@EnableOpenApi
@EnableDiscoveryClient
@EnableAsync
@EnableFeignClients("top.lobot.base.feign")
@ComponentScan(basePackages = {
        "top.lobot.base.config",
        "top.lobot.xo.service",
        "top.lobot.base.fallback",
        "top.lobot.utils",
        "top.lobot.xo.utils",
        "top.lobot.web",
        })
public class WebApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(WebApplication.class, args);
    }

    /**
     * 设置时区
     */
    @PostConstruct
    void setDefaultTimezone() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
    }
}
