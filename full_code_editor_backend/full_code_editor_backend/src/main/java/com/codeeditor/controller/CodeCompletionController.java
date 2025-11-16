package com.codeeditor.controller;

import com.codeeditor.dto.CompletionRequest;
import com.codeeditor.dto.CompletionResponse;
import com.codeeditor.service.ExternalAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/completion")
@RequiredArgsConstructor
@Tag(name = "Code Completion", description = "Endpoints for obtaining AI code completions")
public class CodeCompletionController {

    private final ExternalAiService ai;

    @PostMapping
    @Operation(summary = "Get code completions",
            description = "Return code completion suggestions for the provided source and cursor position")
    public ResponseEntity<CompletionResponse> comp(@RequestBody CompletionRequest r) {
        return ResponseEntity.ok(ai.getCompletions(r.getCode()));
    }
}