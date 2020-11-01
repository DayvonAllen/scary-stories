package com.dna.dev.userservice.repo;

import com.dna.dev.userservice.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TokenRepo extends JpaRepository<Token, UUID> {
}
