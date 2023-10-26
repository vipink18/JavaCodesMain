package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.entities.Customer;
import com.capg.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> insterCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.insterCustomer(customer),HttpStatus.CREATED);
	}
	@PutMapping("/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteCustomer/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int customerId){
		return new ResponseEntity<String>(customerService.deleteCustomer(customerId),HttpStatus.GONE);
	}
	
	@GetMapping("/viewCustomers")
	public ResponseEntity< List<Customer> > viewCustomers(){
		return new ResponseEntity<List<Customer>>(customerService.viewCustomers(),HttpStatus.OK);
		
	}
	
	@GetMapping("/viewCustomer/{customerId}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable int customerId) {
		return new ResponseEntity<Customer>(customerService.viewCustomer(customerId),HttpStatus.OK);
	}

}
