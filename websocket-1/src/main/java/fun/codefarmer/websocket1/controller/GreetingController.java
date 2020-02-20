package fun.codefarmer.websocket1.controller;

import fun.codefarmer.websocket1.bean.Chat;
import fun.codefarmer.websocket1.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @ @ClassName GreetingController
 * @ Descriotion TODO
 * @ Author admin
 * @ Date 2020/2/18 16:31
 **/
@Controller
public class GreetingController {
    //WebSocket 配置好的消息发送模板
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    /** 群聊*/
    //此注解处理浏览器发送来的消息
    @MessageMapping("/hello")
    // 经过处理后，消息转发到
    // simpMessagingTemplate 可以代替下面@SendTo注解
    @SendTo("/topic/greetings")
    public Message greeting(Message message) {
        return message;
    }
    // 例如
//    @MessageMapping("/hello")
//    public void greeting2(Message message) {
//        /**
//         * 第一个参数： 发送地址
//         * 第二个参数：消息
//         */
//        simpMessagingTemplate.convertAndSend("/topic/greetings",message);
//    }
    /** 群聊*/
    //---------------------------------
    /** 单聊*/
    /**
     * 单聊
     * @param principal 保存登录用户信息
     *                  principal 单人消息不能靠消息发送人决定是谁发送的，关键看这里存的是谁发的
     * @param chat 消息对象
     */
    @MessageMapping("/chatonline")
    public void chat(Principal principal, Chat chat) {
        chat.setFrom(principal.getName());
        //发送
        /**
         * 参数一：发送目标
         * 参数二：发送服务器地址
         * 参数三：消息
         */
        simpMessagingTemplate.convertAndSendToUser(chat.getTo(),"/queue/chat",chat);
    }
    /** 单聊*/
}
