/*@Author Deepali Kosta

This the service implementation class for Customer module
in which all all the business logic is written for the Customer module

*/

package com.sastabasta.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sastabasta.exceptions.EmailOrPasswordException;
import com.sastabasta.exceptions.MobileNumberAlreadyExistsException;
import com.sastabasta.entities.Customer;

import com.sastabasta.exceptions.EmailAlreadyRegisteredException;
import com.sastabasta.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer)
			throws EmailAlreadyRegisteredException, MobileNumberAlreadyExistsException {
		if (customerRepository.findByEmail(customer.getEmail()).isPresent()) {
			throw new EmailAlreadyRegisteredException("Email already registered");
		}
		if (customerRepository.findByMobileNo(customer.getMobileNo()).isPresent()) {
			throw new MobileNumberAlreadyExistsException("Mobile number already exists");
		}
		return customerRepository.save(customer);
	}

	@Override
	public Optional<Customer> getCustomerById(int custId) {
		return customerRepository.findById(custId);
	}

	@Override
	public void deleteById(int custId) {

		customerRepository.deleteById(custId);

	}

	@Override
	public Customer editCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> findAllCustomer() {

		return (List<Customer>) customerRepository.findAll();
	}

	@Override
	public Customer findByEmailAndPassword(String email, String password) throws EmailOrPasswordException {
		Customer result = customerRepository.findByEmailAndPassword(email, password);
		if (result == null)
			throw new EmailOrPasswordException("error in ur passsword or email");
		return customerRepository.findByEmailAndPassword(email, password);
	}

}
