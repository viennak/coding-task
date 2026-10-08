package com.example.controller;
import org.springframework.web.bind.annotation.*;

import com.example.service.ChatService;

import com.example.service.ChatService;

@RestController
@RequestMapping("/api/chat")
public class ChatController2 {

    private final ChatService chatService;

    public ChatController2(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {
        String answer = chatService.askClaude(request.message());
        return new ChatResponse(answer);
    }

    public record ChatRequest(String message) {
    }

    public record ChatResponse(String answer) {
    }
}
