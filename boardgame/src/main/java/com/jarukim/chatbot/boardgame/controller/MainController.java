package com.jarukim.chatbot.boardgame.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String Main(Model model) {
        return "main";
    }
}
