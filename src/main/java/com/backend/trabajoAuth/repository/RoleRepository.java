package com.backend.trabajoAuth.repository;

import com.backend.trabajoAuth.models.ERole;
import com.backend.trabajoAuth.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}
