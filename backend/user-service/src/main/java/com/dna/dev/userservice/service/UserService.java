package com.dna.dev.userservice.service;

import com.dna.dev.userservice.api.v1.domain.UserDto;

import java.util.UUID;

public interface UserService {

    UserDto getUserDetails(UUID id);
    UserDto register(UserDto userDto);

}
