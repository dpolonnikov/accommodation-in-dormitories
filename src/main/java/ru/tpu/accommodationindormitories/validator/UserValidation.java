package ru.tpu.accommodationindormitories.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.tpu.accommodationindormitories.exception.UniqueEmailException;
import ru.tpu.accommodationindormitories.exception.UniqueUsernameException;
import ru.tpu.accommodationindormitories.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserValidation {
    private final UserRepository userRepository;

    //Дополнительно будут дописываться проверки
    public void checkUsername(String username) {
        if(userRepository.existsByUsername(username)) {
            throw new UniqueUsernameException("Username is busy!" + username);
        }
    }

    public void checkEmail(String email) {
        if(userRepository.existsByEmail(email)) {
            throw new UniqueEmailException("Email is busy! " + email);
        }
    }
}
