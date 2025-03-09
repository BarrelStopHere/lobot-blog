package top.lobot.web.annotion.limit;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/*
 * @Description: 限流配置
 * @Author: ykr
 * @date:  2025/2/16 16:29
 */
@RefreshScope
@ConfigurationProperties(prefix = "request-limit")
@Component
@Data
public class RequestLimitConfig {
    /**
     * 是否开启请求限制
     */
    private Boolean start;

    /**
     * 允许访问的数量
     */
    private int amount;

    /**
     * 时间段
     */
    private long time;
}
