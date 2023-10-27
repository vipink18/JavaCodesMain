package com.capg.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.capg.externalServices.UserBookingDetails;
import com.capg.util.Booking;

@FeignClient(name = "booking-service", url = "localhost:2025/api/v1/booking")
public interface BookingServiceFeign {

	@PostMapping("/book")
	public Booking book(Booking booking);

	@GetMapping("getAllUserBooking/{userId}")
	public List<UserBookingDetails> getAllUserBooking(@PathVariable String userId);

}
