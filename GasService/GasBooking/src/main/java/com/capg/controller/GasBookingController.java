package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entities.GasBooking;
import com.capg.service.GasBookingService;

@RestController
@RequestMapping("/booking")
public class GasBookingController {

	@Autowired
	GasBookingService bookingService;
	
	@PostMapping("/addbooking")
	public ResponseEntity<GasBooking> insertGasBooking(@RequestBody GasBooking gasBooking) {
		return new ResponseEntity<GasBooking>(bookingService.insertGasBooking(gasBooking),HttpStatus.CREATED);
	}
	
	public ResponseEntity<GasBooking> updateGasBooking(GasBooking gasBooking) {

		return new ResponseEntity<GasBooking>(bookingService.updateGasBooking(gasBooking),HttpStatus.OK);
	}
	public ResponseEntity<String> deleteGasBooking(int gasBookingId) {
		return new ResponseEntity<String>(bookingService.deleteGasBooking(gasBookingId),HttpStatus.OK);
	}
	//no payment module
	//public GasBooking getBill(int gasBookingId);
	public ResponseEntity<List<GasBooking>> viewGasBooking(){
		return new ResponseEntity<List<GasBooking>>(bookingService.viewGasBooking(),HttpStatus.OK);
	}

	
}
