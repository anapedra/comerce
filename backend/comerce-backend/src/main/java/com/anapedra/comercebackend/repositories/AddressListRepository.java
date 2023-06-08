package com.anapedra.comercebackend.repositories;

import com.anapedra.comercebackend.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressListRepository extends JpaRepository<Address,Long> {
}
