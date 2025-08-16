package com.example.aistorygen.service;

import com.example.aistorygen.dto.ChatRequest;
import com.example.aistorygen.dto.ChatResponse;
import com.example.aistorygen.dto.PromptRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class ChatService {
    private final RestClient restClient;
    public ChatService(RestClient restClient){
        this.restClient = restClient;
    }

    @Value("${groq.api.key}")
    private String apiKey;

    @Value("${groq.api.model}")
    private String model;

    @Value("${groq.api.sysmessage}")
    private String systemPrompt;

    public String getChatResponse(PromptRequest promptRequest){

        ChatRequest chatGPTRequest = new ChatRequest(
                model,
                List.of(new ChatRequest.Message("user", promptRequest.prompt()),
                        new ChatRequest.Message("system", promptRequest.prompt()
                        )),
                0.8,
                2000,
                1,
                false
        );

        ChatResponse response = restClient.post()
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .body(chatGPTRequest)
                .retrieve()
                .body(ChatResponse.class);

        return response.choices().get(0).message().content();

    }

}
