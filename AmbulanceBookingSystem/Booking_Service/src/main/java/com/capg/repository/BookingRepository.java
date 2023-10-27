package com.capg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

	List<Booking> findByUserId(String userId);
	List<Booking> findByAmbulanceId(String ambulanceId);
	List<Booking> findByHospitalId(String hospitalId);
	//List<Booking> findByUserId(String userId);
	Optional<Booking> findByTransactionId(String transactionId);
	Optional<Booking> findByBookingId(String bookingId);
}
