package com.anapedra.comercebackend.repositories;

import com.anapedra.comercebackend.entities.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepository extends JpaRepository<Shift,Long> {
}
