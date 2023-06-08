package com.anapedra.comercebackend.repositories;

import com.anapedra.comercebackend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
