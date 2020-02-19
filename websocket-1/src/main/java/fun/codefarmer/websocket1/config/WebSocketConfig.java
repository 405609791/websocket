package fun.codefarmer.websocket1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 *  WebSocket 配置类
 * @ @ClassName WebSocketConfig
 * @ Descriotion TODO
 * @ Author admin
 * @ Date 2020/2/18 15:12
 **/
//代表配置类
@Configuration
//开启消息代理
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    /**
     * 配置消息代理
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //配置 2个
        /**
         * 作用：消息请求路径
         * topic 消息代理的前缀，如果后面发送的消息前缀带有 topic，转发给代理，代理在发送给连接的客户端
         * topic 是路径 一定注意 “/” 如果忘记 /，会导致去服务器取不到消息，能发送，大家都看不到
         */
        registry.enableSimpleBroker("/topic");
        //其二 随意命名
        /**
         * 作用：
         * app  就是配置一个或多个前缀，通过这些前缀过滤出需要被注解的方法
         * 处理的消息，后面会加个具体的方法，哪些消息会被这个方法处理，哪些消息会被代理处理
         * 如果 是以 /app开头就以代理处理
         */
        registry.setApplicationDestinationPrefixes("/app");

    }

    //注册连接点

    /**
     * webSocket 第一件事情需要建立连接，这就是服务端建立连接的点
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
                                    // 前端启用sockJS
        registry.addEndpoint("/chat").withSockJS();
    }
}
