package com.dna.dev.userservice.service;

import com.dna.dev.userservice.api.v1.domain.UserDto;

public interface UserService {
    UserDto register(UserDto userDto);
}
