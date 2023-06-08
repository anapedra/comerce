package com.anapedra.comercebackend.repositories;

import com.anapedra.comercebackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
