package ru.tpu.accommodationindormitories.model;

import jakarta.persistence.*;
import lombok.Data;
import ru.tpu.accommodationindormitories.enums.UserRole;

@Entity
@Table(name="users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String password;
    private String role = UserRole.STUDENT.toString();

}
