package ru.tpu.accommodationindormitories.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="dormitory")
@Data
public class Dormitory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "university")
    private University university;

    private String university_mane;

}
