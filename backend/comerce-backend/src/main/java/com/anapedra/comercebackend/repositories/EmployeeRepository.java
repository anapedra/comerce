package com.anapedra.comercebackend.repositories;

import com.anapedra.comercebackend.entities.Employee;
import com.anapedra.comercebackend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {


}
