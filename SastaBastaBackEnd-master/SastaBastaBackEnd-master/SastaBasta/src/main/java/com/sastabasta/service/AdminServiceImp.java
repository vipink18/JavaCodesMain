/*@Author Shuvam Jyoti Saha

This is the service implementation calss of AdminService, 
in this class the business logic of the method are written to add the 
admin and admin login 

*/
package com.sastabasta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sastabasta.entities.Admin;
import com.sastabasta.exceptions.EmailOrPasswordException;
import com.sastabasta.repository.AdminRespository;

@Service
public class AdminServiceImp implements AdminService {

	@Autowired
	AdminRespository adminRespository;

	@Override
	public Admin findByEmailAndPassword(String email, String password) throws EmailOrPasswordException {

		Admin result = adminRespository.findByEmailAndPassword(email, password);
		if (result == null)
			throw new EmailOrPasswordException("error in ur email or password");
		return adminRespository.findByEmailAndPassword(email, password);

	}

	@Override
	public Admin addAdmin(Admin admin) {
		return adminRespository.save(admin);
	}

}
