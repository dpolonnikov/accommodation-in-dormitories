package ru.tpu.accommodationindormitories.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tpu.accommodationindormitories.dto.JwtAuthenticationDto;
import ru.tpu.accommodationindormitories.dto.RefreshTokenDto;
import ru.tpu.accommodationindormitories.dto.UserCredentialsDto;
import ru.tpu.accommodationindormitories.service.UserServiceImpl;

import javax.security.sasl.AuthenticationException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final UserServiceImpl userService;

    @PostMapping("/sing-in")
    public ResponseEntity<JwtAuthenticationDto> singIn(@RequestBody UserCredentialsDto userCredentialsDto) {
        try {
            JwtAuthenticationDto jwtAuthenticationDto = userService.singIn(userCredentialsDto);
            return ResponseEntity.ok(jwtAuthenticationDto);
        } catch (AuthenticationException exception) {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthenticationDto> refresh(@RequestBody RefreshTokenDto refreshTokenDto) {
        try {
            JwtAuthenticationDto jwtAuthenticationDto = userService.refreshToken(refreshTokenDto);
            return ResponseEntity.ok(jwtAuthenticationDto);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).build();
        }
    }
}