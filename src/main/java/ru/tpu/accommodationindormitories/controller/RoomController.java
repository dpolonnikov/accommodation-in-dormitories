package ru.tpu.accommodationindormitories.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.tpu.accommodationindormitories.model.Room;
import ru.tpu.accommodationindormitories.repository.RoomRepository;
import ru.tpu.accommodationindormitories.service.interfaces.RoomService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms/")
@AllArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/add")
    public Room addRoom(@RequestBody Room room) {
        return roomService.saveRoom(room);
    }

    @GetMapping("/")
    public List<Room> getRooms() {
        return roomService.findAllRooms();
    }

    @PutMapping("/update")
    public Room updateRoom(@RequestBody Room room) {
        return roomService.updateRoom(room);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
    }

}
