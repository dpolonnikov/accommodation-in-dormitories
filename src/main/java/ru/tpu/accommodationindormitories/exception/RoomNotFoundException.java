package ru.tpu.accommodationindormitories.exception;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(String message) {
        super(message);
    }
    public RoomNotFoundException(Long roomId) {
      super("Комната с id " + roomId + " не найдена");
    }
}
