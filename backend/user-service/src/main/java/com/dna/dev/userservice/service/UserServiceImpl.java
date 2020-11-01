package com.dna.dev.userservice.service;

import com.dna.dev.userservice.api.v1.domain.UserDto;
import com.dna.dev.userservice.api.v1.mapper.UserMapper;
import com.dna.dev.userservice.exceptions.EmailTakenException;
import com.dna.dev.userservice.exceptions.UsernameTakenException;
import com.dna.dev.userservice.model.User;
import com.dna.dev.userservice.repo.UserRepo;
import com.dna.dev.userservice.service.helper.UserValidationHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepo userRepo;
    private final UserValidationHelper userValidationHelper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserMapper userMapper, UserRepo userRepo, UserValidationHelper userValidationHelper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userMapper = userMapper;
        this.userRepo = userRepo;
        this.userValidationHelper = userValidationHelper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDto register(UserDto userDto) {
        User user = userMapper.userDtoToUserMapper(userDto);
        if(user != null){
            if (userValidationHelper.isUsernameTaken(user.getUsername())){
                throw new UsernameTakenException("Username: " + user.getUsername() + " is already taken.");
            }
            else if(userValidationHelper.isEmailTaken(user.getEmail())){
                throw new EmailTakenException("Email: " + user.getEmail() + " is already taken.");
            }
            else {
                user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
                user.setJoinDate(LocalDate.now());
                user.setUnlocked(true);
                user.setActive(true);
                return userMapper.userToUserDtoMapper(userRepo.save(user));
            }
        }
        throw new RuntimeException();
    }
}
