package ru.tpu.accommodationindormitories.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tpu.accommodationindormitories.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
