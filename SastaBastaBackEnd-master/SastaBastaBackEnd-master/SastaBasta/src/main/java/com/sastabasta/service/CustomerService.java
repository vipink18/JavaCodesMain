/*@Author Deepali Kosta

This the service interface for Customer module
in which all the methods are declared according 
the to the requirements for customer module

*/
package com.sastabasta.service;

import java.util.*;
import java.util.Optional;

import com.sastabasta.entities.Customer;
import com.sastabasta.exceptions.EmailAlreadyRegisteredException;
import com.sastabasta.exceptions.EmailOrPasswordException;
import com.sastabasta.exceptions.MobileNumberAlreadyExistsException;

public interface CustomerService {

	public Customer addCustomer(Customer customer)
			throws EmailAlreadyRegisteredException, MobileNumberAlreadyExistsException;

	public Optional<Customer> getCustomerById(int custId);

	public void deleteById(int custId);

	public Customer editCustomer(Customer customer);

	public List<Customer> findAllCustomer();

	public Customer findByEmailAndPassword(String email, String password) throws EmailOrPasswordException;

}
