package com.capg.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entity.User;
import com.capg.exception.IdNotFoundException;
import com.capg.exception.InvalidPasswordException;
import com.capg.exception.UsersNotFoundException;
import com.capg.externalServices.UserBookingDetails;
import com.capg.feignClient.BookingServiceFeign;
import com.capg.repository.UserRepository;
import com.capg.util.Booking;
import com.capg.util.UserLogin;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public BookingServiceFeign bookingServiceFeign;

	// for creating user
	@Override
	public User createUser(User user) {
		String uuid = UUID.randomUUID().toString();
		user.setUserId(uuid);
		log.info("User created with ID: {}", uuid);
		return userRepository.save(user);
	}

	// find user by id
	@Override
	public Optional<User> getUserById(String userId) {
		log.info("Getting user by ID: {}", userId);
		return userRepository.findById(userId);
	}

	// update the user details
	@Override
	public User updateUser(String userId, User user) throws IdNotFoundException {
		// TODO Auto-generated method stub
		User userObj = userRepository.findById(userId).orElseThrow(() -> new IdNotFoundException("Invalid Id"));
		userObj.setUserName(user.getUserName());
		userObj.setUserContactNumber(user.getUserContactNumber());
		userObj.setUserLocation(user.getUserLocation());
		return userRepository.save(userObj);
	}

	// for deleting the user
	@Override
	public void deleteUser(String userId) throws IdNotFoundException {
		log.info("Deleting user with ID: {}", userId);
		Optional<User> userObj = userRepository.findById(userId);
		if (userObj.isEmpty()) {
			throw new IdNotFoundException("Not Found user");
		}
		userRepository.delete(userObj.get());
	}

	// find user by email id
	@Override
	public Optional<User> getUserByEmailId(String userEmailId) throws IdNotFoundException {
		log.info("Getting user by emailId: {}", userEmailId);
		return userRepository.getUserByUserEmailId(userEmailId);
	}

	@Override
	public User changePassword(String userEmailId, String currentPassword, String newPassword) {
		log.info("Changing password for user with emailID: {}", userEmailId);
		Optional<User> userObj = getUserByEmailId(userEmailId);
		if (userObj.get().getUserPassword().equals(currentPassword)) {
			if (Objects.nonNull(userObj.get().getUserPassword())
					&& !"".equalsIgnoreCase(userObj.get().getUserPassword())) {
				userObj.get().setUserPassword(newPassword);
				userRepository.save(userObj.get());
			}
		} else {
			throw new InvalidPasswordException("Wrong current password.");
		}
		return userObj.get();
	}

	// view all users
	@Override
	public List<User> viewAllUser() throws UsersNotFoundException {
		log.info("Viewing all users");
		List<User> users = userRepository.findAll();
		if (users == null) {
			throw new UsersNotFoundException("No users found");
		}
		return users;
	}

	// user login
	@Override
	public User userLogin(UserLogin userLogin) {
		log.info("User login with emailId: {}", userLogin.getEmailId());
		return userRepository.findByUserEmailIdAndUserPassword(userLogin.getEmailId(), userLogin.getPassword());
	}

	public Booking bookAmbulance(String userId, String hospitalId, String ambulanceId) {
		log.info("Request received to book ambulance. userId: {}, hospitalId: {}, ambulanceId: {}", userId, hospitalId,
				ambulanceId);
		if (userId.equals(null) || hospitalId.equals(null) || ambulanceId.equals(null)) {
			throw new IdNotFoundException("Id not found!");
		}
		Booking booking = new Booking(userId, hospitalId, ambulanceId);
		return bookingServiceFeign.book(booking);
	}

	public List<UserBookingDetails> userBookingHistory(String userId) {
		log.info("Request received to view previous bookings for userId: {}", userId);
		return bookingServiceFeign.getAllUserBooking(userId);
	}

}