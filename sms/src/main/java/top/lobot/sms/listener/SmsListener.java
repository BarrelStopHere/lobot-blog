package top.lobot.sms.listener;

import top.lobot.sms.util.SmsUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/*
 * @Description: 短信监听器 
 * @Author: ykr
 * @date:  2025/2/16 17:54
 */
@Component
public class SmsListener {

    @Autowired
    private SmsUtil smsUtil;

    @RabbitListener(queues = "lobot.sms")
    public void sendSms(Map<String, String> map) {
        //TODO 短信发送暂时不用
//        try {
//            SendSmsResponse response = smsUtil.sendSms(
//                    map.get("mobile"),
//                    map.get("template_code"),
//                    map.get("sign_name"),
//                    map.get("param"));
//            System.out.println("code:" + response.getCode());
//            System.out.println("message:" + response.getMessage());
//
//        } catch (ClientException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }

}
