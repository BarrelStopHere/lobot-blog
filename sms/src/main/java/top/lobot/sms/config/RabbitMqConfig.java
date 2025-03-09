package top.lobot.sms.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * @Description:  生成交换机
 * @Author: ykr
 * @date:  2025/2/16 17:49
 */
@Configuration
public class RabbitMqConfig {

    public static final String LOBOT_BLOG = "lobot.blog";
    public static final String LOBOT_EMAIL = "lobot.email";
    public static final String LOBOT_SMS = "lobot.sms";
    public static final String EXCHANGE_DIRECT = "exchange.direct";
    public static final String ROUTING_KEY_BLOG = "lobot.blog";
    public static final String ROUTING_KEY_EMAIL = "lobot.email";
    public static final String ROUTING_KEY_SMS = "lobot.sms";

    /**
     * 声明交换机
     */
    @Bean(EXCHANGE_DIRECT)
    public Exchange EXCHANGE_DIRECT() {
        // 声明路由交换机，durable:在rabbitmq重启后，交换机还在
        return ExchangeBuilder.directExchange(EXCHANGE_DIRECT).durable(true).build();
    }

    /**
     * 声明Blog队列
     *
     * @return
     */
    @Bean(LOBOT_BLOG)
    public Queue LOBOT_BLOG() {
        return new Queue(LOBOT_BLOG);
    }

    /**
     * 声明Email队列
     *
     * @return
     */
    @Bean(LOBOT_EMAIL)
    public Queue LOBOT_EMAIL() {
        return new Queue(LOBOT_EMAIL);
    }

    /**
     * 声明SMS队列
     *
     * @return
     */
    @Bean(LOBOT_SMS)
    public Queue LOBOT_SMS() {
        return new Queue(LOBOT_SMS);
    }

    /**
     * lobot.blog 队列绑定交换机，指定routingKey
     *
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding BINDING_QUEUE_INFORM_BLOG(@Qualifier(LOBOT_BLOG) Queue queue, @Qualifier(EXCHANGE_DIRECT) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_BLOG).noargs();
    }

    /**
     * lobot.mail 队列绑定交换机，指定routingKey
     *
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding BINDING_QUEUE_INFORM_EMAIL(@Qualifier(LOBOT_EMAIL) Queue queue, @Qualifier(EXCHANGE_DIRECT) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_EMAIL).noargs();
    }

    /**
     * lobot.sms 队列绑定交换机，指定routingKey
     *
     * @param queue
     * @param exchange
     * @return
     */
    @Bean
    public Binding BINDING_QUEUE_INFORM_SMS(@Qualifier(LOBOT_SMS) Queue queue, @Qualifier(EXCHANGE_DIRECT) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_SMS).noargs();
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
