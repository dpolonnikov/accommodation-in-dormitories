package ru.tpu.accommodationindormitories.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tpu.accommodationindormitories.model.University;

public interface UniversityRepository extends JpaRepository<University, Long> {
}
