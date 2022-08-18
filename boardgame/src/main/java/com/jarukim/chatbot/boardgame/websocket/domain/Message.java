package com.jarukim.chatbot.boardgame.websocket.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String type;
    private String sender;
    private String receiver;
    private Object data;

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void newConnect() {
        this.type = "NEW";
    }

    public void closeConnect() {
        this.type = "CLOSE";
    }

    @Override
    public String toString() {
        return "{data: \"" + data + "\"}";
    }
}
