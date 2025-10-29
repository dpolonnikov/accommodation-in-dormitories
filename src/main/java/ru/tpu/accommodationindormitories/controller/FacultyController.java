package ru.tpu.accommodationindormitories.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tpu.accommodationindormitories.model.Faculty;
import ru.tpu.accommodationindormitories.service.interfaces.FacultyService;

import java.util.List;

@RestController
@RequestMapping("Faculties")
@AllArgsConstructor
public class FacultyController {
    private final FacultyService facultyService;

    @GetMapping()
    public List<Faculty> getFaculties() {
        return facultyService.findAllFaculties();
    }
}
