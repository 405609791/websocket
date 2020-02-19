package fun.codefarmer.websocket1.controller;

import fun.codefarmer.websocket1.bean.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @ @ClassName GreetingController
 * @ Descriotion TODO
 * @ Author admin
 * @ Date 2020/2/18 16:31
 **/
@Controller
public class GreetingController {
    //此注解处理浏览器发送来的消息
    @MessageMapping("/hello")
    // 经过处理后，消息转发到
    @SendTo("/topic/greetings")
    public Message greeting(Message message) {
        return message;
    }
}
