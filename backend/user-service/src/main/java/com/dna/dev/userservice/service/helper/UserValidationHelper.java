package com.dna.dev.userservice.service.helper;

import com.dna.dev.userservice.model.User;
import com.dna.dev.userservice.repo.UserRepo;
import org.springframework.stereotype.Component;

@Component
public class UserValidationHelper {

    private final UserRepo userRepo;

    public UserValidationHelper(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Boolean isUsernameTaken(String username){
        User user = userRepo.findUserByUsername(username);
        return user != null;
    }

    public Boolean isEmailTaken(String email){
        User user = userRepo.findUserByEmail(email);
        return user != null;
    }
}
