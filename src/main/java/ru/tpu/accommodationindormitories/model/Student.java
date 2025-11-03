package ru.tpu.accommodationindormitories.model;

import jakarta.persistence.*;
import lombok.Data;
import ru.tpu.accommodationindormitories.enums.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private String faculty;
    private Integer course;
    private Boolean disabledStudent;
    private Boolean isOrphan;
    private Integer numberOfViolations;
    private LocalDate checkInDate;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @OneToMany(mappedBy = "student")
    private List<AccommodationRequest> requests = new ArrayList<>();


}
