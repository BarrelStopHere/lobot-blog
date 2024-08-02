package top.lobot.base.config.log;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 日志线程配置类
 *
 * @author ykr
 * @date 2024/8/2
 */
@Configuration
public class LogThreadPoolConfig {

    @Value("${log.thread.corePoolSize}")
    private int corePoolSize;

    @Value("${log.thread.maxPoolSize}")
    private int maxPoolSize;

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(){
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(corePoolSize);
        threadPoolTaskExecutor.setMaxPoolSize(maxPoolSize);
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        return threadPoolTaskExecutor;
    }
}
