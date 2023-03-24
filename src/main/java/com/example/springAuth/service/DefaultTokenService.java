package com.example.springAuth.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class DefaultTokenService implements TokenService {
    /**
     * Реализация интерфейса TokenService по генерации токенов.
     * JWT - стандарт на основании JSON, для создания токенов.
     * 3 части:
     * * Заголовок
     * * Тело
     * * Подпись
     * JWT формируется из набора утверждений:
     * * Издатель токена (iss)
     * * Направление в какой сервис (aud)
     * * Идентификатор клиента (sub)
     * * Текущее время формаирования токена (iat)
     * * Вычисленное время окончания действия токена 5 минут (exp)
     */
    @Value("${auth.jwt.secret}")
    private String secretKey;

    @Override
    public String generateToken(String clientId) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        Instant now = Instant.now();
        Instant exp = now.plus(5, ChronoUnit.MINUTES);

        return JWT.create()
                .withIssuer("auth-service")
                .withAudience("viewingbook")
                .withSubject(clientId)
                .withIssuedAt(Date.from(now))
                .withExpiresAt(Date.from(exp))
                .sign(algorithm);
    }

}
