package com.jonghak.firstproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.jonghak.firstproject.provider.WebSocketProvider;

import lombok.RequiredArgsConstructor;

@EnableWebSocket
@Configuration
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {

    private final WebSocketProvider webSocketProvider;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //@ addHandler(핸들러 객체, 어떤 핸들러로 보낼 건지 URL 지정)
        //@ setAllowedOrigins("*") => 모든 출처에 대해 받겠다
        registry
        .addHandler(webSocketProvider, "/web-socket")
        .setAllowedOrigins("*");
    }
    
    
    
}
