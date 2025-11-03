package ru.tpu.accommodationindormitories.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.tpu.accommodationindormitories.dto.AccommodationRequestStudentDto;
import ru.tpu.accommodationindormitories.model.Student;
import ru.tpu.accommodationindormitories.service.interfaces.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students/")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping()
    public List<Student> getStudents() {
        return studentService.findAllStudents();
    }

    @PostMapping("{id}/send-request")
    public ResponseEntity<String> sendRequest(@PathVariable String id, @RequestBody AccommodationRequestStudentDto request) {
        return ResponseEntity.ok(studentService.sendRequest(request, Long.parseLong(id)));
    }

    @GetMapping("{id}/requests/")
    public List<AccommodationRequestStudentDto> getAllRequests(@PathVariable String id) {
        return studentService.findAllRequest(Long.parseLong(id));
    }
}
