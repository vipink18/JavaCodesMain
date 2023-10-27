package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entity.AmbulanceBookingDetails;
import com.capg.entity.Booking;
import com.capg.entity.HospitalBookingDetails;
import com.capg.entity.UserBookingDetails;
import com.capg.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RequestMapping("/api/v1/booking")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	private static final Logger log = LoggerFactory.getLogger(BookingController.class);
	
	@PostMapping("/book")
	public ResponseEntity<Booking> book(@RequestBody Booking booking) {
		log.info("Creating booking");
		return new ResponseEntity<Booking>(bookingService.createBooking(booking), HttpStatus.CREATED);
	}

	@GetMapping("getAllUserBooking/{userId}")
	public ResponseEntity<List<UserBookingDetails>> getAllUserBooking(@PathVariable String userId) {
		 log.info("Fetching all user bookings for userId: {}", userId);
		return new ResponseEntity<List<UserBookingDetails>>(bookingService.getAllUserBooking(userId), HttpStatus.OK);

	}

	@GetMapping("getAllAmbulanceBooking/{ambulanceId}")
	public ResponseEntity<List<AmbulanceBookingDetails>> getAllAmbulanceBooking(@PathVariable String ambulanceId) {
		log.info("Fetching all ambulance bookings for ambulanceId: {}", ambulanceId);
		return new ResponseEntity<List<AmbulanceBookingDetails>>(bookingService.getAllAmbulanceBooking(ambulanceId),
				HttpStatus.OK);
	}

	@GetMapping("getAllHospitalBooking/{hospitalId}")
	public ResponseEntity<List<HospitalBookingDetails>> getAllHospitalBooking(@PathVariable String hospitalId) {
		log.info("Fetching all hospital bookings for hospitalId: {}", hospitalId);
		return new ResponseEntity<List<HospitalBookingDetails>>(bookingService.getAllHospitalBooking(hospitalId),
				HttpStatus.OK);
	}

	@GetMapping("getAllBooking")
	public ResponseEntity<List<Booking>> getAllBooking() {
		log.info("Fetching all bookings");
		return new ResponseEntity<List<Booking>>(bookingService.getAllBooking(), HttpStatus.OK);
	}
}

