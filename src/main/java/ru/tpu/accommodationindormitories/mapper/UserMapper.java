package ru.tpu.accommodationindormitories.mapper;

import org.mapstruct.Mapper;
import ru.tpu.accommodationindormitories.dto.UserDto;
import ru.tpu.accommodationindormitories.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
    User toEntity(UserDto userDto);
}
