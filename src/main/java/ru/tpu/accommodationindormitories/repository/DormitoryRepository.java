package ru.tpu.accommodationindormitories.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tpu.accommodationindormitories.model.Dormitory;


public interface DormitoryRepository extends JpaRepository<Dormitory, Long> {
}
