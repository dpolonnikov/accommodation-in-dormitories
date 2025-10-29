package ru.tpu.accommodationindormitories.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tpu.accommodationindormitories.model.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
