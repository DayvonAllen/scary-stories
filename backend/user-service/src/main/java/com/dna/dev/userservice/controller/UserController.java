package com.dna.dev.userservice.controller;

import com.dna.dev.userservice.api.v1.domain.UserDto;
import com.dna.dev.userservice.exceptions.ScaryStoryException;
import com.dna.dev.userservice.filter.WebFilter;
import com.dna.dev.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public MappingJacksonValue getUserDetails(@PathVariable UUID id){
        WebFilter webFilter = new WebFilter();
        return webFilter.webFilter("BeanFilter",userService.getUserDetails(id), "id", "username", "email", "lastLoginDate", "joinDate");
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody UserDto userDto, Errors errors){
        if(errors.hasErrors()){
            throw new ScaryStoryException(errors
                    .getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining(", ")));
        }
        UserDto userDto1 = userService.register(userDto);
        System.out.println(userDto1.getId());
    }
}
