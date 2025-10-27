package ru.tpu.accommodationindormitories.model;

import jakarta.persistence.*;
import lombok.Data;

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
    private Double price;
}
