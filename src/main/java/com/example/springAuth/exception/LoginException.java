package com.example.springAuth.exception;

public class LoginException extends RuntimeException {
    /**
     * Класс исключений выбрасывающий сообщение ошибки в логине и введения неверных данных
     */

    public LoginException(String message) {
        super(message);
    }
}