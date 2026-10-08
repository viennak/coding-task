package com.example.config;

package com.example.claudedemo;

import org.springframework.ai.anthropic.AnthropicChatOptions;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {

    @Bean
    ChatClient chatClient(ChatClient.Builder builder) {
        return builder

                // Set the assistant's general behavior for every request.
                // This helps keep answers consistent.
                .defaultSystem(
                        "You are a helpful assistant. Explain technical topics in simple English."
                )

                // Set model settings used by default.
                // A lower temperature generally makes answers less random.
                .defaultOptions(
                        AnthropicChatOptions.builder()
                                .temperature(0.3)
                                .maxTokens(500)
                                .build()
                )

                // Build the ChatClient bean so Spring can provide it to ChatService.
                .build();
    }
}

