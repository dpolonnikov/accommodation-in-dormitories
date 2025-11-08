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
    @JoinColumn(name = "student_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @ManyToOne
    @JoinColumn(name = "dormitory_id")
    private Dormitory dormitory;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;


    private String first_name;
    private String middle_name;
    private String last_name;
    private String citizenship; //Гражданство
    private String education; //На какой уровень образования поступает (бакалавр, мага и т.д)
    private String admission_method; //Поступает через баллы егэ/олимпиаду/вступительные
    private String[] hobby;
    private String[] sport;

}
