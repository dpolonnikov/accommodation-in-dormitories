package ru.tpu.accommodationindormitories.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String message) {
        super(message);
    }
    public StudentNotFoundException(Long studentId) {
        super("Студент с id " + studentId + " не найден");
    }
}
