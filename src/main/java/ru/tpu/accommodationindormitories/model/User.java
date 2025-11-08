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
    private String login;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String password;
    private String user_role;

    //@Enumerated(EnumType.STRING)
    //private UserRole role = UserRole.STUDENT;

}
