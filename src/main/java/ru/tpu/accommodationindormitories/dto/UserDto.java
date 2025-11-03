package ru.tpu.accommodationindormitories.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {
    private Long id;

    @NotBlank(message = "Email is required!")
    @Pattern(regexp = "[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9_-]+", message = "Email is incorrect format")
    private String email;

    @NotBlank(message = "Password is required!")
    @Size(min = 8, max = 64, message = "Password should be from 8 to 64 characters")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{8,}$", message = "Password must contain at least one digit, one special character, one lowercase and one uppercase letter")
    private String password;

    @NotBlank(message = "Username is null!")
    @Pattern(regexp = "^^[a-zA-Z][a-zA-Z0-9_-]+$", message = "Username must start with a letter and contain only letters, numbers and hyphens")
    @Size(min = 5, max = 50, message = "Username should be from 5 to 50 characters")
    private String username;

    @NotBlank(message = "First name is required")
    @Size(max = 50, message = "First name must not exceed 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 50, message = "Last name must not exceed 50 characters")
    private String lastName;

    private String role;
}