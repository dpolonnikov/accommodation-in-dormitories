package ru.tpu.accommodationindormitories.service.interfaces;

import ru.tpu.accommodationindormitories.model.Room;

import java.util.List;

public interface RoomService {
    public List<Room> findAllRooms();
    public Room saveRoom(Room room);
    public Room updateRoom(Room room);
    public void deleteRoom(Long id);
}
