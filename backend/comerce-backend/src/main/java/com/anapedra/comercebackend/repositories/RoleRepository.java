package com.anapedra.comercebackend.repositories;

import com.anapedra.comercebackend.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
