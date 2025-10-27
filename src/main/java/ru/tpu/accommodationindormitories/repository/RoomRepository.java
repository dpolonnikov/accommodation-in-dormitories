package ru.tpu.accommodationindormitories.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.tpu.accommodationindormitories.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
