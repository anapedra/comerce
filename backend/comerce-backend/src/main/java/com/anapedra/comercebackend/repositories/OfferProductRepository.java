package com.anapedra.comercebackend.repositories;

import com.anapedra.comercebackend.entities.OfferProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferProductRepository extends JpaRepository<OfferProduct,Long> {
}
