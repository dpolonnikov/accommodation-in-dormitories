package ru.tpu.accommodationindormitories.repository;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import ru.tpu.accommodationindormitories.model.Room;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT r FROM Room r WHERE r.id = :roomId")
    @EntityGraph(attributePaths = {"students"})
    Optional<Room> findByIdWithLock(Long roomId);
}
