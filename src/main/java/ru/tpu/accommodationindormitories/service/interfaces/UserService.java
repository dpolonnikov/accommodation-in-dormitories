package ru.tpu.accommodationindormitories.service.interfaces;

import ru.tpu.accommodationindormitories.dto.JwtAuthenticationDto;
import ru.tpu.accommodationindormitories.dto.RefreshTokenDto;
import ru.tpu.accommodationindormitories.dto.UserCredentialsDto;
import ru.tpu.accommodationindormitories.dto.UserDto;

import javax.security.sasl.AuthenticationException;

public interface UserService {
    JwtAuthenticationDto singIn(UserCredentialsDto userCredentialsDto) throws AuthenticationException;
    JwtAuthenticationDto refreshToken(RefreshTokenDto refreshTokenDto) throws AuthenticationException;
    UserDto findUserByUsername(String username);
    UserDto findUserById(Long id);
    String addUser(UserDto user);
}
