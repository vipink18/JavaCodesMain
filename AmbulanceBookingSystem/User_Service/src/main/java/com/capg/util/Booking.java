package com.capg.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
//	@Id
//	private String bookingId;
	private String userId;
	private String hospitalId;
	private String ambulanceId;
	// private LocalDateTime bookingTime;

//	public Booking(String userId, String hospitalId) {
//		super();
//		this.userId = userId;
//		this.hospitalId = hospitalId;
//	}

//	 
}
