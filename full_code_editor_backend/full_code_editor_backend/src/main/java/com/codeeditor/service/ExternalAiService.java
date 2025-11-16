package com.codeeditor.service;

import com.codeeditor.dto.CompletionResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ExternalAiService {

    private final RestTemplate rest = new RestTemplate();

    @Value("${external.ai.key}")
    private String apiKey;

    @Value("${external.ai.url}")
    private String url;

    public CompletionResponse getCompletions(String code) {

        Map<String, Object> requestBody = Map.of(
                "model", "gemini-2.5-flash",
                "reasoning_effort", "low",
                "messages", List.of(
                        Map.of(
                                "role", "user",
                                "content", code
                        )
                )
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(apiKey);

        HttpEntity<?> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = rest.exchange(
                url,
                HttpMethod.POST,
                request,
                Map.class
        );

        List<String> suggestions = new ArrayList<>();

        if (response.getBody() != null &&
                response.getBody().get("choices") instanceof List<?> choicesList) {

            Map<?, ?> choice = (Map<?, ?>) choicesList.get(0);
            Map<?, ?> message = (Map<?, ?>) choice.get("message");

            if (message != null && message.get("content") != null) {
                suggestions.add(String.valueOf(message.get("content")));
            }
        }

        return new CompletionResponse(suggestions);
    }

}
