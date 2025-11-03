package ru.tpu.accommodationindormitories.mapper;

import org.mapstruct.Mapper;
import ru.tpu.accommodationindormitories.dto.AccommodationRequestStudentDto;
import ru.tpu.accommodationindormitories.model.AccommodationRequest;

@Mapper(componentModel = "spring")
public interface AccommodationRequestStudentMapper {
    AccommodationRequestStudentDto toDto(AccommodationRequest request);
    AccommodationRequest toEntity(AccommodationRequestStudentDto request);
}
