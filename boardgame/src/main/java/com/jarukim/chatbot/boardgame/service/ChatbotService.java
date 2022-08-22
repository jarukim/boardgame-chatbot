package com.jarukim.chatbot.boardgame.service;

import org.springframework.stereotype.Service;

@Service
public class ChatbotService {
    public String test(String num) {
        if ("1".equals(num)) {
            return "어떤 테마가 좋은가요?";
        } else {
            return "정확한 숫자를 입력하세요.";
        }
    }
}
