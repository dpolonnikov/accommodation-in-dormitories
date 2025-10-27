package ru.tpu.accommodationindormitories.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tpu.accommodationindormitories.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
