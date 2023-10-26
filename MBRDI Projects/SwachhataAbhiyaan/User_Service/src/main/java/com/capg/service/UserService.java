package com.capg.service;

import java.util.List;
import java.util.UUID;

import com.capg.entities.Complaint;
import com.capg.entities.User;

public interface UserService{
	
	public User addUser(User user);
	
	public User getUserById(UUID userId);
	
	public User updateUser();
	
	public void deleteUsser(UUID userId);
	
	public User addComplaint(User user);
	
	public List<User> searchAreaBy(String area);
	
	public List<Complaint> showAllComplaint();
	
	

}
