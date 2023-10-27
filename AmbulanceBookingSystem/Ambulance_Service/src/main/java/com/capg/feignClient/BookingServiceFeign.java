package com.capg.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capg.exrternalServices.AmbulanceBookingDetails;

@FeignClient(name = "booking-service", url = "localhost:2025/api/v1/booking")
public interface BookingServiceFeign {

//	@GetMapping("getAllUserBooking/{userId}")
//	public List<Booking> getAllUserBooking(@PathVariable String userId);
	
	@GetMapping("getAllAmbulanceBooking/{ambulanceId}")
	public List<AmbulanceBookingDetails> getAllAmbulanceBooking(@PathVariable String ambulanceId);
	
}
