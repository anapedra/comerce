package com.anapedra.comercebackend.repositories;

import com.anapedra.comercebackend.entities.PhoneList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneListRepository extends JpaRepository<PhoneList,Long> {
}
