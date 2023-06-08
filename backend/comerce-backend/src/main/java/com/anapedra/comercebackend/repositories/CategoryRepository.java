package com.anapedra.comercebackend.repositories;

import com.anapedra.comercebackend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
