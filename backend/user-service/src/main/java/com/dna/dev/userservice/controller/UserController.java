package com.dna.dev.userservice.controller;

import com.dna.dev.userservice.api.v1.domain.UserDto;
import com.dna.dev.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    private UserDto register(@RequestBody UserDto userDto){
        return userService.register(userDto);
    }
}
