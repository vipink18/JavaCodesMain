package com.capg.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.entities.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address, UUID>{

	Address findByAddressUuid(UUID addressUuid);
}
