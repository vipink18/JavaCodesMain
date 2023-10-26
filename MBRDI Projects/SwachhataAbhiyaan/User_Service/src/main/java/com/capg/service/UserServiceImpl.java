package com.capg.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.entities.Complaint;
import com.capg.entities.User;
import com.capg.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(UUID userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUsser(UUID userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User addComplaint(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> searchAreaBy(String area) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Complaint> showAllComplaint() {
		// TODO Auto-generated method stub
		return null;
	}

}
