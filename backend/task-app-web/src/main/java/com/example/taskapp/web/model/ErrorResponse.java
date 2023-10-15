package com.example.taskapp.web.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    // TODO OpenAPIで定義する

    private int status;
    private String error;
    private String message;
    private String path;

    public String toJson(ObjectMapper om) throws JsonProcessingException {
        return om.writeValueAsString(this);
    }
}