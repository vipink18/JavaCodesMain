package com.capg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.capg.entity.User;
import com.capg.externalServices.UserBookingDetails;
import com.capg.util.Booking;
import com.capg.util.UserLogin;

@Service
public interface UserService {

	public User createUser(User user);

	public Optional<User> getUserById(String userId);

	public User updateUser(String userId,User user);
	
	public void deleteUser(String userId);

	public User userLogin(UserLogin userLogin);

	public Optional<User> getUserByEmailId(String userEmailId);

	public User changePassword(String userEmailId, String currentPassword, String newPassword);

	public List<User> viewAllUser();
	
	public Booking bookAmbulance(String userId,String hospitalId,String ambulanceId);
	
	public List<UserBookingDetails> userBookingHistory(String userId);

}