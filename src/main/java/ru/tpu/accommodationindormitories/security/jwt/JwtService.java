package ru.tpu.accommodationindormitories.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecurityException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.tpu.accommodationindormitories.dto.JwtAuthenticationDto;

import javax.crypto.SecretKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class JwtService {
    private static final Logger LOGGER = LogManager.getLogger(JwtService.class);

    private final SecretKey secretKey;

    public JwtService() {
        // Автоматическая генерация безопасного ключа
        this.secretKey = Jwts.SIG.HS256.key().build();

        // Для отладки - выводим сгенерированный ключ
        String base64Key = java.util.Base64.getEncoder().encodeToString(secretKey.getEncoded());
        LOGGER.info("Generated JWT Secret Key (Base64): {}", base64Key);
    }

    public JwtAuthenticationDto generateAuthToken(String username) {
        JwtAuthenticationDto jwtAuthenticationDto = new JwtAuthenticationDto();
        jwtAuthenticationDto.setToken(generateJwtToken(username));
        jwtAuthenticationDto.setRefreshToken(generateRefreshToken(username));
        return jwtAuthenticationDto;
    }

    public JwtAuthenticationDto refreshBaseToken(String username, String refreshToken) {
        JwtAuthenticationDto jwtAuthenticationDto = new JwtAuthenticationDto();
        jwtAuthenticationDto.setToken(generateJwtToken(username));
        jwtAuthenticationDto.setRefreshToken(refreshToken);
        return jwtAuthenticationDto;
    }

    public String getUsernameFromToken(String token) {
        if (token == null || token.trim().isEmpty()) {
            throw new IllegalArgumentException("Token cannot be null or empty");
        }

        Claims claims = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claims.getSubject();
    }

    public boolean booleanValidateJwtToken(String token) {
        // Проверяем, что токен не пустой
        if (token == null || token.trim().isEmpty()) {
            LOGGER.warn("Token is null or empty");
            return false;
        }

        try {
            Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (ExpiredJwtException expiredJwtException) {
            LOGGER.error("Expired JwtException", expiredJwtException);
        } catch (UnsupportedJwtException unsupportedJwtException) {
            LOGGER.error("Unsupported Jwt Exception", unsupportedJwtException);
        } catch (MalformedJwtException malformedJwtException) {
            LOGGER.error("Malformed JwtException", malformedJwtException);
        } catch (SecurityException securityException) {
            LOGGER.error("Security Exception", securityException);
        } catch (Exception e) {
            LOGGER.error("Invalid token", e);
        }
        return false;
    }

    private String generateJwtToken(String username) {
        Date date = Date.from(LocalDateTime.now().plusMinutes(15)
                .atZone(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .subject(username)
                .expiration(date)
                .signWith(secretKey)
                .compact();
    }

    private String generateRefreshToken(String username) {
        Date date = Date.from(LocalDateTime.now().plusDays(31)
                .atZone(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .subject(username)
                .expiration(date)
                .signWith(secretKey)
                .compact();
    }
}