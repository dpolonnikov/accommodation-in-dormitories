package ru.tpu.accommodationindormitories.dto;

import lombok.Data;
import ru.tpu.accommodationindormitories.model.Student;

import java.time.LocalDate;

@Data
public class AccommodationRequestStudentDto {
    private Long id;
    private Student student;
    private String status;
    private LocalDate requestDate;
    private String specialRequirements;
    private String preferences;
}
