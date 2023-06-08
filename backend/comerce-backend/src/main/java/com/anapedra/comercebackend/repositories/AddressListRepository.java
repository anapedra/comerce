package com.anapedra.comercebackend.repositories;

import com.anapedra.comercebackend.entities.AddressList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressListRepository extends JpaRepository<AddressList,Long> {
}
