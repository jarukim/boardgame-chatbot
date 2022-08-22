package com.jarukim.chatbot.boardgame.websocket;

import com.jarukim.chatbot.boardgame.service.ChatbotService;
import com.jarukim.chatbot.boardgame.websocket.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class WebSocketHandler extends TextWebSocketHandler {
    @Autowired
    public ChatbotService service;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String sessionId = session.getId();
        Message message = Message.builder()
                .sender("System")
                .receiver(sessionId)
                .data("안녕하세요. 보드게임을 추천해드립니다.")
                .build();
        message.newConnect();

        session.sendMessage(new TextMessage(message.toString()));
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("session = " + session + ", message = " + message);

        String payload = message.getPayload();
        session.sendMessage(new TextMessage(service.test(payload)));

        super.handleTextMessage(session, message);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        super.handleTransportError(session, exception);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
    }
}
