package com.anapedra.comercebackend.repositories;


import com.anapedra.comercebackend.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentRepository extends JpaRepository<Department,Long> {
}
