package ru.tpu.accommodationindormitories.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tpu.accommodationindormitories.model.University;
import ru.tpu.accommodationindormitories.service.interfaces.UniversityService;

import java.util.List;

@RestController
@RequestMapping("University")
@AllArgsConstructor
public class UniversityController {
    private final UniversityService universityService;

    @GetMapping()
    public List<University> getUniversities() {
        return universityService.findAllUniversities();
    }
}
