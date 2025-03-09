package top.lobot.sms.listener;

import top.lobot.sms.util.SendMailUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/*
 * @Description: 邮件监听器 
 * @Author: ykr
 * @date:  2025/2/16 17:54
 */
@Slf4j
@Component
public class MailListener {

    @Autowired
    private SendMailUtils sendMailUtils;

    @RabbitListener(queues = "lobot.email")
    public void sendMail(Map<String, String> map) {
        if (map != null) {
            sendMailUtils.sendEmail(
                    map.get("subject"),
                    map.get("receiver"),
                    map.get("text")
            );
        }
    }
}
