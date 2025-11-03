package ru.tpu.accommodationindormitories.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.tpu.accommodationindormitories.dto.UserDto;
import ru.tpu.accommodationindormitories.model.User;
import ru.tpu.accommodationindormitories.service.UserServiceImpl;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping("/new-user")
    public ResponseEntity<String> addUser(@Validated @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.addUser(userDto));
    }
    @GetMapping("/{id}")
    public UserDto findUserById(@PathVariable String id) {
        return userService.findUserById(Long.parseLong(id));
    }
}