package com.example.springAuth.controller;

import com.example.springAuth.exception.LoginException;
import com.example.springAuth.exception.RegistrationException;
import com.example.springAuth.model.ErrorResponse;
import com.example.springAuth.model.TokenResponse;
import com.example.springAuth.model.User;
import com.example.springAuth.service.ClientService;
import com.example.springAuth.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    /**
     * Контроллер с двумя эндпоинтами:
     * * reister - принятие http-запроса при регистрации нового пользователя в системе
     * * getToken - принятие http-запроса при успешной автооризации пользователя ( выдача токена сессии)
     */

    private final ClientService clientService;
    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody User user) {
        clientService.register(user.getClientId(), user.getClientSecret());
        return ResponseEntity.ok("Registered");
    }

    @PostMapping("/token")
    public TokenResponse getToken(@RequestBody User user) {
        clientService.checkCredentials(user.getClientId(), user.getClientSecret());
        return new TokenResponse(tokenService.generateToken(user.getClientId()));
    }

    @ExceptionHandler({RegistrationException.class, LoginException.class})
    public ResponseEntity<ErrorResponse> handleUserRegistrationException(RuntimeException ex) {
        return ResponseEntity
                .badRequest()
                .body(new ErrorResponse(ex.getMessage()));
    }
}