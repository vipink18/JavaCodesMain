package com.capg.feignClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capg.externalServices.HospitalBookingDetails;

@FeignClient(name = "booking-service", url = "localhost:2025/api/v1/booking")
public interface BookingServiceFeign {

//	@GetMapping("getAllUserBooking/{userId}")
//	public List<HospitalBookingDetails> getAllUserBooking(@PathVariable String userId);

	@GetMapping("getAllHospitalBooking/{hospitalId}")
	public List<HospitalBookingDetails> getAllHospitalBooking(@PathVariable String hospitalId);

}
