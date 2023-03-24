package com.example.springAuth.service;

public interface TokenService {
    /**
     * Интерфейс сервисного слоя для генерации токенов
     */
    String generateToken(String clientId);
}
