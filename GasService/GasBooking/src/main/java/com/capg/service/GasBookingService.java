package com.capg.service;

import java.util.List;

import com.capg.entities.GasBooking;

public interface GasBookingService {
	
	public GasBooking insertGasBooking(GasBooking gasBooking);
	public GasBooking updateGasBooking(GasBooking gasBooking);
	public String deleteGasBooking(int gasBookingId);
	//no payment module
	//public GasBooking getBill(int gasBookingId);
	public List<GasBooking> viewGasBooking();

}
