package ru.tpu.accommodationindormitories.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.tpu.accommodationindormitories.model.Room;
import ru.tpu.accommodationindormitories.repository.RoomRepository;
import ru.tpu.accommodationindormitories.service.interfaces.RoomService;

import java.util.List;

@Service
@AllArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    @Override
    public List<Room> findAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
