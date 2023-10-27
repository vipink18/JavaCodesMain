package com.capg.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AmbulanceBookingDetails {
	
	private LocalDateTime bookingTime;
	private User user;
	private Hospital hospital;
	
}

