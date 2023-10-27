package com.capg;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.capg.entity.Ambulance;
import com.capg.entity.Booking;
import com.capg.feignClient.UserServiceFeign;
import com.capg.repository.BookingRepository;
import com.capg.service.BookingService;

@SpringBootTest
class BookingServiceApplicationTests {

	@Autowired
	BookingService userService;

	@Autowired
	private BookingService bookingService;

	@MockBean
	private BookingRepository bookingRepository;

	@Autowired
	UserServiceFeign userServiceFeign;

	private Booking booking1;

	private Booking booking2;
	
	private Ambulance ambulance;

	private List<Booking> bookings;

	@BeforeEach
	public void BokingServiceTestSetup() {
		booking1 = new Booking("12345", "23456", "34567", "45678", "56789", LocalDateTime.now());
		booking2 = new Booking("54321", "23456", "76543", "87654", "98765", LocalDateTime.now());
		bookings =new ArrayList();
		bookings.add(booking1);
		bookings.add(booking2);
	}
	

	
	
	@Test
	public void getBookingByIdTest() {
		Mockito.when(bookingRepository.findById("12345")).thenReturn(Optional.of(booking1));
        assertThat(bookingService.getBookingById("12345")).isEqualTo(Optional.of(booking1));

	}

	

	@Test
	public void getBookingByUserIdTest() {
		Mockito.when(bookingRepository.findByUserId("23456")).thenReturn(bookings);
        assertThat(bookingService.getBookingByUserId("23456")).isEqualTo(bookings);

	}
	
	@Test
	public void getAllBookingTest() {
		Mockito.when(bookingRepository.findAll()).thenReturn(bookings);
        assertThat(bookingService.getAllBooking()).isEqualTo(bookings);
		
	}
		

	@Test
	public void getBookingByAmbulanceIdTest() {
		Mockito.when(bookingRepository.findByAmbulanceId("45678")).thenReturn(bookings);
        assertThat(bookingService.getBookingByAmbulanceId("45678")).isEqualTo(bookings);
	

	}

	@Test
	public void getBookingByHospitalIdTest() {
		// TODO Auto-generated method stub
		Mockito.when(bookingRepository.findByHospitalId("34567")).thenReturn(bookings);
        assertThat(bookingService.getBookingByHospitalId("34567")).isEqualTo(bookings);
	
	
	}
//	
	@Test
	public void getAllUserBookingTest(){
		Mockito.when(bookingRepository.findByHospitalId("23456")).thenReturn(bookings);
        assertThat(bookingService.getBookingByHospitalId("23456")).isEqualTo(bookings);
	
		 
	}

	@Test
	public void getBookingByTransactionIdTest() {
		Mockito.when(bookingRepository.findByTransactionId("56789")).thenReturn(Optional.of(booking1));
        assertThat(bookingService.getBookingByTransactionId("56789")).isEqualTo(Optional.of(booking1));
	}
}
