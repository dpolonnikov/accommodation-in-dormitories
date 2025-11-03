package ru.tpu.accommodationindormitories.model;

import jakarta.persistence.*;
import lombok.Data;
import ru.tpu.accommodationindormitories.enums.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="room")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer roomNumber;
    private Integer floor;
    private Integer numberOfSeats;
    private Integer roomCapacity;
    private Double price;
    private Boolean isBusy;
    private Boolean forDisabledPeople;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToMany(mappedBy = "room")
    private List<Student> students = new ArrayList<>();
    @OneToMany(mappedBy = "room")
    private List<AccommodationRequest> requests = new ArrayList<>();
}
