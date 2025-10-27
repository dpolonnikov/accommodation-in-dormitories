package ru.tpu.accommodationindormitories.model;

import jakarta.persistence.*;
import lombok.Data;

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
    private String course;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;


}
