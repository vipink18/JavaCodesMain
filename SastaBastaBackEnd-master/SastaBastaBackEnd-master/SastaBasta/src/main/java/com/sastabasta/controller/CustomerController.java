/*@Author Deepali Kosta

This is Controller layer for Customer module 
In this class client request is mapped  to the method and sends back the response to the client 

In this controller all the request related to customer are handled

*/

package com.sastabasta.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sastabasta.entities.Customer;
import com.sastabasta.entities.Product;
import com.sastabasta.exceptions.CustomServiceException;
import com.sastabasta.exceptions.EmailAlreadyRegisteredException;
import com.sastabasta.exceptions.EmailOrPasswordException;
import com.sastabasta.exceptions.EmptyCustomerListException;
import com.sastabasta.exceptions.MobileNumberAlreadyExistsException;
import com.sastabasta.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws CustomServiceException {

		try {
			return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.OK);
		} catch (EmailAlreadyRegisteredException | MobileNumberAlreadyExistsException e) {
			throw new CustomServiceException(e.getMessage());
		}

	}

	@GetMapping("/allCustomer")
	public ResponseEntity<List<Customer>> findAllCustomer() throws EmptyCustomerListException {
		return new ResponseEntity<List<Customer>>(customerService.findAllCustomer(), HttpStatus.OK);
	}

	@PutMapping("/editCustomer")
	public ResponseEntity<Customer> editCustomer(@RequestBody Customer customer) {
		return new ResponseEntity<Customer>(customerService.editCustomer(customer), HttpStatus.OK);
	}

	@DeleteMapping("deleteById/{id}")
	public void deleteCustomerById(@PathVariable int id) {
		customerService.deleteById(id);
	}

	@GetMapping("/getCustomer/{custId}")
	public ResponseEntity<Optional<Customer>> getByCustId(@PathVariable int custId) {
		return new ResponseEntity<Optional<Customer>>(customerService.getCustomerById(custId), HttpStatus.OK);
	}

	@GetMapping("/getAllDetails/{custId}")
	public List<Product> getAllDetails(@PathVariable int custId) throws EmptyCustomerListException {
	
	List<Product> product =	customerService.getCustomerById(custId).get().getWishlist().getProduct();
		
		return product;
	}

	@PostMapping("/login")
	public ResponseEntity<Customer> checkLogin(@RequestBody Customer customer) throws EmailOrPasswordException {
		return new ResponseEntity<Customer>(
				customerService.findByEmailAndPassword(customer.getEmail(), customer.getPassword()), HttpStatus.OK);
	}
}