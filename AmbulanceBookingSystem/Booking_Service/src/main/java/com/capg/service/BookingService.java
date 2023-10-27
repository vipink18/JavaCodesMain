package com.capg.service;


import java.util.List;
import java.util.Optional;

import com.capg.entity.AmbulanceBookingDetails;
import com.capg.entity.Booking;
import com.capg.entity.HospitalBookingDetails;
import com.capg.entity.UserBookingDetails;

public interface BookingService {

	
	public Booking createBooking(Booking booking);
	public Optional<Booking> getBookingById(String bookingId);
	public List<Booking> getBookingByUserId(String userId);
	public List<Booking> getAllBooking();
	public List<Booking> getBookingByAmbulanceId(String ambulanceId);
	public List<Booking> getBookingByHospitalId(String hospitalId);
	//void declineBookingRequest(String bookingId);
	//void getPaymentByBookingId(String bookingId);
	//void makePayment(User user, String bookingId, double amount);
	public List<UserBookingDetails> getAllUserBooking(String userId);
	public List<AmbulanceBookingDetails> getAllAmbulanceBooking(String ambulanceId);
	public List<HospitalBookingDetails> getAllHospitalBooking(String hospitalId);
	//public List<Booking> getBookingByPaymentId(String paymentId);
	public Optional<Booking> getBookingByTransactionId(String transactionId);
	public void deleteBookingByBookingId(String bookingId);
	public Optional<Booking> getBookingByBookingId(String bookingId);
}
