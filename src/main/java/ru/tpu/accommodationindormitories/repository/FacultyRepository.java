package ru.tpu.accommodationindormitories.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tpu.accommodationindormitories.model.Faculty;


public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
