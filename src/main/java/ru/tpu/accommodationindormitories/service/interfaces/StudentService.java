package ru.tpu.accommodationindormitories.service.interfaces;

import ru.tpu.accommodationindormitories.dto.AccommodationRequestStudentDto;
import ru.tpu.accommodationindormitories.model.Student;

import java.util.List;

public interface StudentService {
     List<Student> findAllStudents();
     String sendRequest(AccommodationRequestStudentDto request, Long id);
     List<AccommodationRequestStudentDto> findAllRequest(Long id);

}
