package com.example.springAuth.model;

import lombok.Value;

@Value
public class ErrorResponse {
    /**
     * Объект запроса, при неудачном получении токена
     */
    String message;
}
