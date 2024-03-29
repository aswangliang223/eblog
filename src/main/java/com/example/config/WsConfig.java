package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 *  @author WangLiang
 * @EnableWebSocketMessageBroker表示开启使用STOMP协议来传输基于代理的消息
 */
@EnableAsync
@Configuration
@EnableWebSocketMessageBroker
public class WsConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册一个端点，websocket的访问地址
        registry.addEndpoint("/websocket")
                .withSockJS(); //
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //推送消息前缀
        registry.enableSimpleBroker("/user/", "/topic/");
        registry.setApplicationDestinationPrefixes("/app");
    }
}
