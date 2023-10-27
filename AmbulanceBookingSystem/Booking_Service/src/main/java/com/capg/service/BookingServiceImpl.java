package com.capg.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.Ambulance;
import com.capg.entity.AmbulanceBookingDetails;
import com.capg.entity.Booking;
import com.capg.entity.Hospital;
import com.capg.entity.HospitalBookingDetails;
import com.capg.entity.Payment;
import com.capg.entity.User;
import com.capg.entity.UserBookingDetails;
import com.capg.exceptions.IdNotFoundException;
import com.capg.feignClient.AmbulanceServiceFeign;
import com.capg.feignClient.HospitalServiceFeign;
import com.capg.feignClient.PaymentServiceFeign;
import com.capg.feignClient.UserServiceFeign;
import com.capg.repository.BookingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class BookingServiceImpl implements BookingService {

private static final Logger log = LoggerFactory.getLogger(BookingServiceImpl.class);
    
    @Autowired
    private BookingRepository bookingRepository;

    // feign's

    @Autowired
    private AmbulanceServiceFeign ambulanceServiceFeign;

    @Autowired
    private HospitalServiceFeign hospitalServiceFeign;

    @Autowired
    private PaymentServiceFeign paymentServiceFeign;

    @Autowired
    private UserServiceFeign userServiceFeign;

    // public Booking createBooking(Booking booking, String userId, String
    // ambulanceId, String hospitalId ) {
    public Booking createBooking(Booking booking) {
        log.info("Creating a new booking for user: {}", booking.getUserId());
        Ambulance ambulance = ambulanceServiceFeign.findAmbulanceById(booking.getAmbulanceId());
        String ambulanceType = ambulance.getAmbType();

        Payment payment = paymentServiceFeign.doPayment(booking.getUserId(), ambulanceType);
        String str = UUID.randomUUID().toString();

        booking.setTransactionId(payment.getTransactionId());
        booking.setBookingId(str);
        booking.setBookingTime(LocalDateTime.now());
        bookingRepository.save(booking);
        return booking;
    }

    @Override
    public List<Booking> getBookingByUserId(String userId) {
        log.info("Fetching bookings for user with ID: {}", userId);
        return bookingRepository.findByUserId(userId);
    }

    @Override
    public List<Booking> getAllBooking() {
        log.info("Fetching all bookings");
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getBookingByAmbulanceId(String ambulanceId) {
        log.info("Fetching bookings for ambulance with ID: {}", ambulanceId);
        return bookingRepository.findByAmbulanceId(ambulanceId);
    }

    @Override
    public List<Booking> getBookingByHospitalId(String hospitalId) {
        log.info("Fetching bookings for hospital with ID: {}", hospitalId);
        return bookingRepository.findByHospitalId(hospitalId);
    }

    @Override
    public Optional<Booking> getBookingByTransactionId(String transactionId) {
        log.info("Fetching booking for transaction with ID: {}", transactionId);
        return bookingRepository.findByTransactionId(transactionId);
    }

    @Override
    public List<UserBookingDetails> getAllUserBooking(String userId) {
        log.info("Fetching all user bookings for user with ID: {}", userId);
        List<UserBookingDetails> userBookingDetails = new ArrayList<>();

        List<Booking> booking = getBookingByUserId(userId);

        List<Hospital> hospitals = new ArrayList<>();
        List<Ambulance> ambulances = new ArrayList<>();
        for (Booking book : booking) {
            Hospital temp = hospitalServiceFeign.getHospitalById(book.getHospitalId());
            Hospital hospital = new Hospital(temp.getHospitalName(), temp.getHospitalContactNumber(),
                    temp.getHospitalAddress(), temp.getHospitalEmailId());
            hospitals.add(hospital);

            Ambulance ambtemp = ambulanceServiceFeign.findAmbulanceById(book.getAmbulanceId());
            Ambulance ambulance = new Ambulance(ambtemp.getAmbDriverName(), ambtemp.getAmbDriverEmailId(),
                    ambtemp.getAmbDriverContactNumber(), ambtemp.getAmbDriverLocation(), ambtemp.getAmbType());
            ambulances.add(ambulance);
            userBookingDetails.add(new UserBookingDetails(book.getBookingTime(), ambulance, hospital));
        }
        return userBookingDetails;
    }

    @Override
    public List<AmbulanceBookingDetails> getAllAmbulanceBooking(String ambulanceId) {
        log.info("Fetching all ambulance bookings for ambulance with ID: {}", ambulanceId);
        List<AmbulanceBookingDetails> ambulanceBookingDetails = new ArrayList<>();

        List<Booking> booking = getBookingByAmbulanceId(ambulanceId);

        List<Hospital> hospitals = new ArrayList<>();
        List<User> users = new ArrayList<>();

        for (Booking book : booking) {
            Hospital temp = hospitalServiceFeign.getHospitalById(book.getHospitalId());
            Hospital hospital = new Hospital(temp.getHospitalName(), temp.getHospitalContactNumber(),
                    temp.getHospitalAddress(), temp.getHospitalEmailId());
            hospitals.add(hospital);

            Optional<User> userTemp = userServiceFeign.getUserById(book.getUserId());
            User user = new User(userTemp.get().getUserName(), userTemp.get().getUserContactNumber(), userTemp.get().getUserEmailId(),
                    userTemp.get().getUserLocation());
            users.add(user);

            // ............................

            ambulanceBookingDetails.add(new AmbulanceBookingDetails(book.getBookingTime(), user, hospital));

        }

        return ambulanceBookingDetails;

    }

    @Override
    public List<HospitalBookingDetails> getAllHospitalBooking(String hospitalId) {
        log.info("Fetching all hospital bookings for hospital with ID: {}", hospitalId);
        List<HospitalBookingDetails> hospitalBookingDetails = new ArrayList<>();

        List<Booking> booking = getBookingByHospitalId(hospitalId);

        List<Ambulance> ambulances = new ArrayList<>();
        List<User> users = new ArrayList<>();

        for (Booking book : booking) {

            Ambulance ambtemp = ambulanceServiceFeign.findAmbulanceById(book.getAmbulanceId());
            Ambulance ambulance = new Ambulance(ambtemp.getAmbDriverName(), ambtemp.getAmbDriverEmailId(),
                    ambtemp.getAmbDriverContactNumber(), ambtemp.getAmbDriverLocation(), ambtemp.getAmbType());
            ambulances.add(ambulance);

            Optional<User> userTemp = userServiceFeign.getUserById(book.getUserId());
            User user = new User(userTemp.get().getUserName(), userTemp.get().getUserContactNumber(), userTemp.get().getUserEmailId(),
                    userTemp.get().getUserLocation());
            users.add(user);
            // ............................
            hospitalBookingDetails.add(new HospitalBookingDetails(book.getBookingTime(), user, ambulance));
        }

        return hospitalBookingDetails;
    }

    @Override
    public Optional<Booking> getBookingById(String bookingId) {
        log.info("Fetching booking with ID: {}", bookingId);
        return bookingRepository.findById(bookingId);
    }

    @Override
    public void deleteBookingByBookingId(String bookingId) {
        log.info("Deleting booking with ID: {}", bookingId);
        Optional<Booking> book = bookingRepository.findByBookingId(bookingId);
        if (book.isEmpty())
            throw new IdNotFoundException("Invalid Id.");
        bookingRepository.delete(book.get());

    }

    @Override
    public Optional<Booking> getBookingByBookingId(String bookingId) {
        log.info("Fetching booking with ID: {}", bookingId);
        return bookingRepository.findByBookingId(bookingId);
    }

}
