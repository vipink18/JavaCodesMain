package com.capg.service;

import java.util.List;

import com.capg.entities.Customer;

public interface CustomerService {
	
	public Customer insterCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public String deleteCustomer(int customerId);
	public List<Customer> viewCustomers();
	public Customer viewCustomer(int customerId);
	

}
