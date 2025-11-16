package com.codeeditor.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompletionResponse {

 private List<String> suggestions;
}
