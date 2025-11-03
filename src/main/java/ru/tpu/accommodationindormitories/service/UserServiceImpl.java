package ru.tpu.accommodationindormitories.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.tpu.accommodationindormitories.dto.JwtAuthenticationDto;
import ru.tpu.accommodationindormitories.dto.RefreshTokenDto;
import ru.tpu.accommodationindormitories.dto.UserCredentialsDto;
import ru.tpu.accommodationindormitories.dto.UserDto;
import ru.tpu.accommodationindormitories.exception.StudentNotFoundException;
import ru.tpu.accommodationindormitories.mapper.UserMapper;
import ru.tpu.accommodationindormitories.model.User;
import ru.tpu.accommodationindormitories.repository.UserRepository;
import ru.tpu.accommodationindormitories.security.jwt.JwtService;
import ru.tpu.accommodationindormitories.service.interfaces.UserService;
import ru.tpu.accommodationindormitories.validator.UserValidation;

import javax.security.sasl.AuthenticationException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserValidation userValidation;

    @Override
    public JwtAuthenticationDto singIn(UserCredentialsDto userCredentialsDto) throws AuthenticationException {
        User user = findByCredentials(userCredentialsDto);
        return jwtService.generateAuthToken(user.getUsername());
    }

    @Override
    public JwtAuthenticationDto refreshToken(RefreshTokenDto refreshTokenDto) throws AuthenticationException {
        String refreshToken = refreshTokenDto.getRefreshToken();
        if(refreshToken != null && jwtService.booleanValidateJwtToken(refreshToken)) {
            String username = jwtService.getUsernameFromToken(refreshToken);
            User user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new AuthenticationException("User not found"));
            return jwtService.refreshBaseToken(user.getUsername(), refreshToken);
        }
        throw new AuthenticationException("Invalid refresh token");
    }

    @Override
    public UserDto findUserByUsername(String username) {
        return userMapper.toDto(userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username)));
    }

    @Override
    public UserDto findUserById(Long id) {
        return userMapper.toDto(userRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("User not found with id: " + id)));
    }

    @Override
    public String addUser(UserDto userDto) {
        userValidation.checkUsername(userDto.getUsername());
        userValidation.checkEmail(userDto.getEmail());
        User user = userMapper.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User added";
    }

    private User findByCredentials(UserCredentialsDto userCredentialsDto) throws AuthenticationException {
        Optional<User> optionalUser = userRepository.findByUsername(userCredentialsDto.getUsername());
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            if(passwordEncoder.matches(userCredentialsDto.getPassword(), user.getPassword())) {
                return user;
            }
        }
        throw new AuthenticationException("Incorrect password or username");
    }
}