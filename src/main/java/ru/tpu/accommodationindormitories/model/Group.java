package ru.tpu.accommodationindormitories.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="group")
@Data
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "faculty")
    private Faculty faculty;

    private String group_number;
    private String direction;


}
