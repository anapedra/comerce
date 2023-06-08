package com.anapedra.comercebackend.repositories;

import com.anapedra.comercebackend.entities.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepository extends JpaRepository<Absence,Long> {
}
