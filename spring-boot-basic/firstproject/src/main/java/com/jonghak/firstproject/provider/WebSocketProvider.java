package com.jonghak.firstproject.provider;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketProvider extends TextWebSocketHandler {

    // @ 연결
    @Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        
	}

    // @ 메세지 송수신
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

	}

    // @ 연결 해제
    @Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {

	}
}
