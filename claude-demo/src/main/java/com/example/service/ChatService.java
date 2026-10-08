package com.example.service;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private final ChatClient chatClient;

    

    public String askClaudeV1(String message) {
        return chatClient.prompt()
        //.system("You are internal IT helpdesk Assistance")
                .user(message)
                .call()
                .content();
    }

    
    public ChatService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public ChatService(ChatClient.Builder builder) {
        //this.chatClient = builder.build();
        this.chatClient = builder
                .defaultSystem("You are a helpful assistant. Explain technical topics in simple English.")
                .build();
    }

    public String askClaude(String message) {
        return chatClient.prompt()

                // Provide the changing user question for this request.
                .user(message)

                // Send the request to Claude and return its text answer.
                .call()
                .content();
    }
}



