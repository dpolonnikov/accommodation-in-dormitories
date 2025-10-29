package ru.tpu.accommodationindormitories.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="faculty")
@Data
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "university")
    private University university;

    private String faculty_name;
}
