package com.anapedra.comercebackend.repositories;

import com.anapedra.comercebackend.entities.Documents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentsRepository extends JpaRepository<Documents,Long> {
}
