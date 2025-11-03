package ru.tpu.accommodationindormitories.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tpu.accommodationindormitories.dto.AccommodationRequestStudentDto;
import ru.tpu.accommodationindormitories.exception.StudentNotFoundException;
import ru.tpu.accommodationindormitories.mapper.AccommodationRequestStudentMapper;
import ru.tpu.accommodationindormitories.model.AccommodationRequest;
import ru.tpu.accommodationindormitories.model.Student;
import ru.tpu.accommodationindormitories.repository.RoomRepository;
import ru.tpu.accommodationindormitories.repository.StudentRepository;
import ru.tpu.accommodationindormitories.service.interfaces.AccommodationRequestRepository;
import ru.tpu.accommodationindormitories.service.interfaces.StudentService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final RoomRepository roomRepository;
    private final AccommodationRequestRepository accommodationRequestRepository;
    private final AccommodationRequestStudentMapper accommodationMapper;
    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public String sendRequest(AccommodationRequestStudentDto request, Long id) {
        AccommodationRequest accommodationRequestStudent = accommodationMapper.toEntity(request);
        Student student = studentRepository.findById(id).orElseThrow(()-> new StudentNotFoundException("Студент не найден!" + id));
        student.getRequests().add(accommodationRequestStudent);
        accommodationRequestStudent.setStudent(student);
        accommodationRequestStudent.setRequestDate(LocalDate.now());
        accommodationRequestRepository.save(accommodationRequestStudent);
        return "Request added";
    }

    @Override
    public List<AccommodationRequestStudentDto> findAllRequest(Long id) {
        List<AccommodationRequest> accommodationRequestList = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found! " + id))
                .getRequests();
        List<AccommodationRequestStudentDto> accommodationRequestStudentDtoList = new ArrayList<>();
        for (AccommodationRequest accommodationRequest : accommodationRequestList) {
            accommodationRequestStudentDtoList.add(accommodationMapper.toDto(accommodationRequest));
        }
        return accommodationRequestStudentDtoList;
    }
}
