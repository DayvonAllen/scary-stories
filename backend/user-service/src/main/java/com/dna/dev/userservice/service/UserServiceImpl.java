package com.dna.dev.userservice.service;

import com.dna.dev.userservice.api.v1.domain.UserDto;
import com.dna.dev.userservice.api.v1.mapper.UserMapper;
import com.dna.dev.userservice.exceptions.EmailTakenException;
import com.dna.dev.userservice.exceptions.UserNotFoundException;
import com.dna.dev.userservice.exceptions.UsernameTakenException;
import com.dna.dev.userservice.model.User;
import com.dna.dev.userservice.repo.UserRepo;
import com.dna.dev.userservice.service.helper.UserValidationHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserValidationHelper userValidationHelper;

    public UserServiceImpl(UserMapper userMapper, UserRepo userRepo, BCryptPasswordEncoder bCryptPasswordEncoder, UserValidationHelper userValidationHelper) {
        this.userMapper = userMapper;
        this.userRepo = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userValidationHelper = userValidationHelper;
    }

    @Override
    public UserDto getUserDetails(UUID id) {
        User user = userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User with the ID: " + id + " was not found."));
        return userMapper.userToUserDtoMapper(user);
    }

    @Override
    public UserDto register(UserDto userDto) {
        User user = userMapper.userDtoToUserMapper(userDto);
        if(userValidationHelper.isUsernameTaken(user.getUsername())){
            throw new UsernameTakenException("Username: " + user.getUsername() + " is taken.");
        }
        if(userValidationHelper.isEmailTaken(user.getEmail())){
            throw new EmailTakenException("Email: " + user.getEmail() + " is taken.");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setJoinDate(LocalDate.now());
        user.setUnlocked(true);
        user.setActive(true);
        return userMapper.userToUserDtoMapper(userRepo.save(user));
    }
}
