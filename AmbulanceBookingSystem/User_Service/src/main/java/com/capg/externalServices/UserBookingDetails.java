package com.capg.externalServices;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBookingDetails {

	private LocalDateTime bookingTime;
	private Ambulance ambulance;
	private Hospital hospital;
}
