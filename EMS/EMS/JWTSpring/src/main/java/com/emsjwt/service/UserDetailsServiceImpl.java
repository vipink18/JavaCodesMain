package com.emsjwt.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emsjwt.clients.EmployeeClient;
import com.emsjwt.model.EmployeeModel;
import com.emsjwt.model.Login;
import com.emsjwt.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	EmployeeClient employeeClient;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		EmployeeModel employeeModel = employeeClient.getEmployeeByName(username);
//		Login user = userRepository.findByUsername(username);
		if(employeeModel == null) {
			throw new UsernameNotFoundException("User Not Found with username: "+username);
		}
		Login user = new Login(employeeModel.getName(), employeeModel.getPassword(), employeeModel.getRole());
		
		return UserDetailsImpl.getUser(user);
	}

}
