package com.solvd.users.web.mapper;

import com.solvd.users.domain.User;
import com.solvd.users.web.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto entityToDto(User user);

    User dtoToEntity(UserDto userDto);

}
