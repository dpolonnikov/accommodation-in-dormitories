package ru.tpu.accommodationindormitories.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tpu.accommodationindormitories.model.Student;
import ru.tpu.accommodationindormitories.repository.StudentRepository;
import ru.tpu.accommodationindormitories.service.interfaces.StudentService;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }
}
