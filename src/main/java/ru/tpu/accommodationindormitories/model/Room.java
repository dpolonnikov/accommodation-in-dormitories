package ru.tpu.accommodationindormitories.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name="room")
@Data
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dormitory")
    private Dormitory dormitory;

    private Integer roomNumber;
    private Integer numberOfSeats;
    private LocalDate date_of_repair;
}
