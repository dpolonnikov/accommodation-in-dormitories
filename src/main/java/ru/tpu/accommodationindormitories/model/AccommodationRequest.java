package ru.tpu.accommodationindormitories.model;

import jakarta.persistence.*;
import lombok.Data;
import ru.tpu.accommodationindormitories.enums.RequestStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "requests")
public class AccommodationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status = RequestStatus.PENDING.toString();
    private LocalDate requestDate;
    private String specialRequirements;
    private String preferences;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
