package com.example.springAuth.model;

import lombok.Value;

@Value
public class TokenResponse {
    /**
     * Объект запроса, при успешном получении токена
     */
    String token;
}
