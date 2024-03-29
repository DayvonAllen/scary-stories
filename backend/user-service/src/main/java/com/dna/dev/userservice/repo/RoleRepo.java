package com.dna.dev.userservice.repo;

import com.dna.dev.userservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepo extends JpaRepository<Role, UUID> {
}
