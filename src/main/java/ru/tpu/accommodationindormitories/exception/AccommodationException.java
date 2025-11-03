package ru.tpu.accommodationindormitories.exception;

import java.util.List;

public class AccommodationException extends RuntimeException {
    public AccommodationException(String message) {
        super(message);
    }

    public AccommodationException(List<String> messages) {
        super(String.join("; ", messages));
    }
}
