package com.example.springAuth.model;

import lombok.Data;

@Data
public class User {
    /**
     * Объект запроса, при аутентификации данных пользователя
     */
    String clientId;
    String clientSecret;
}
