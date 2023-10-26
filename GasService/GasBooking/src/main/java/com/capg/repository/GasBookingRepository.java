package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.entities.GasBooking;

@Repository
public interface GasBookingRepository extends JpaRepository<GasBooking, Integer>{

	
}
