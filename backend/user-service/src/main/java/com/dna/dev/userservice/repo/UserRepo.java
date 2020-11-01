package com.dna.dev.userservice.repo;

import com.dna.dev.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepo extends JpaRepository<User, UUID> {
    User findUserByUsername(String username);
    User findUserByEmail(String email);
}
