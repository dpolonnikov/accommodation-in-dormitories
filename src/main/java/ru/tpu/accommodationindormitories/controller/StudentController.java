package ru.tpu.accommodationindormitories.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tpu.accommodationindormitories.model.Student;
import ru.tpu.accommodationindormitories.service.interfaces.StudentService;

import java.util.List;

@RestController
@RequestMapping("students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping()
    public List<Student> getStudents() {
        return studentService.findAllStudents();
    }
}
