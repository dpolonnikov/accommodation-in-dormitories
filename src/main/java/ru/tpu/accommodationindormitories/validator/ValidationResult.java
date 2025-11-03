package ru.tpu.accommodationindormitories.validator;

import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class ValidationResult {
    @Getter
    private final boolean valid;
    private final List<String> errors;

    public ValidationResult(boolean valid, List<String> errors) {
        this.valid = valid;
        this.errors = errors;
    }

}
