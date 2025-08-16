package com.example.aistorygen.dto;

import java.util.List;

public record ChatRequest(String model, List<Message> messages, double temperature, int max_tokens, int top_p, boolean stream) {
    public static record Message (String role, String content){}
}
