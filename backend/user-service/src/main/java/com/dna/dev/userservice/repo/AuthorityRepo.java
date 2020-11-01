package com.dna.dev.userservice.repo;

import com.dna.dev.userservice.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorityRepo extends JpaRepository<Authority, UUID> {
}
