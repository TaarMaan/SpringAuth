package com.example.springAuth.service;

public interface ClientService {
    /**
     * сервис, включающий в себя логику регистрации нового пользователя и проверки
     */
    void register(String clientId, String clientSecret);

    void checkCredentials(String clientId, String clientSecret);
}
