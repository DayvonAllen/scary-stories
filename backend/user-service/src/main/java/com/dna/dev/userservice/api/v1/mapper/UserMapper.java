package com.dna.dev.userservice.api.v1.mapper;

import com.dna.dev.userservice.api.v1.domain.UserDto;
import com.dna.dev.userservice.model.User;

public interface UserMapper {
    UserDto userToUserDtoMapper(User user);
    User userDtoToUserMapper(UserDto userDto);
}
