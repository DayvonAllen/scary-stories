package com.dna.dev.userservice.service.helper;

import com.dna.dev.userservice.exceptions.EmptyFieldException;
import com.dna.dev.userservice.model.User;
import com.dna.dev.userservice.repo.UserRepo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class UserValidationHelper {

    private final UserRepo userRepo;

    public UserValidationHelper(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Boolean isUsernameTaken(String username){
        if(StringUtils.isEmpty(username)){
            throw new EmptyFieldException("Username can't be empty.");
        }
        User user = userRepo.findUserByUsername(username);
        return user != null;
    }

    public Boolean isEmailTaken(String email){
        if(StringUtils.isEmpty(email)){
            throw new EmptyFieldException("Email can't be empty.");
        }
        User user = userRepo.findUserByEmail(email);
        return user != null;
    }
}
