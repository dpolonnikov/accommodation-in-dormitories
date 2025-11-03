package ru.tpu.accommodationindormitories.exceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.tpu.accommodationindormitories.exception.UniqueEmailException;
import ru.tpu.accommodationindormitories.exception.UniqueUsernameException;

import javax.security.sasl.AuthenticationException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<String> handleException(AuthenticationException exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Authentification failed" + exception.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleUsernameNotFoundException(UsernameNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Registration failed" + exception.getMessage());
    }

    @ExceptionHandler(UniqueUsernameException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> handleUniqueUsernameException(UniqueUsernameException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Registration failed" + exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleUniqueEmailException(MethodArgumentNotValidException exception) {
        List<String> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Validation failed, " + String.join(", ", errors));
    }

    @ExceptionHandler(UniqueEmailException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> handleUniqueEmailException(UniqueEmailException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Registration failed" + exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleGenericException(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error" + exception.getMessage());
    }
}
