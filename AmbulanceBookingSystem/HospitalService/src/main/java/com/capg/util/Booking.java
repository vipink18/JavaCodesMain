package com.capg.util;

import java.time.LocalDateTime;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
	@Id
	private String bookingId;
	private String userId;
	private String hospitalId;
	private String ambulanceId;

	// private String userLocation;

	// private String pickupLocation;

	// private Double cost;
	private LocalDateTime bookingTime;

	public Booking(String userId, String hospitalId) {
		super();
		this.userId = userId;
		this.hospitalId = hospitalId;
	}

	public Booking(String bookingId, String userId, String hospitalId, String ambulanceId) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.hospitalId = hospitalId;
		this.ambulanceId = ambulanceId;
	}
}