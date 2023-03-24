package com.example.springAuth.exception;

public class RegistrationException extends RuntimeException {
    /**
     * Класс исключений выбрасывающий сообщение при ошибках регистрации
     */
    public RegistrationException(String message) {
        super(message);
    }
}