package ru.tpu.accommodationindormitories.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.tpu.accommodationindormitories.service.interfaces.AccommodationService;

@RestController
@RequestMapping("/api/v1/accommodation/")
@AllArgsConstructor
public class AccommodationController {
    private final AccommodationService accommodationService;
    @PostMapping("")
    public void accommodation(@RequestParam Long studentId, @RequestParam  Long roomId) {
        accommodationService.accommodationStudentToRoom(studentId, roomId);
    }
}
