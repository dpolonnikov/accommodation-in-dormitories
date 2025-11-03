package ru.tpu.accommodationindormitories.dto;

import lombok.Data;

@Data
public class JwtAuthenticationDto {
    private String token;
    private String refreshToken;
}
