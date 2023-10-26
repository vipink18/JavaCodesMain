/*@author Deepali Kosta

This the repository layer for customer module in which
custom methods is written to find the customer by Email, password,mobileNo
*/

package com.sastabasta.repository;

import java.util.Optional;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sastabasta.entities.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {	  
	
	public Optional<Customer> findByEmail(String email);
	public Customer findByEmailAndPassword(String email,String password);
	public Optional<Customer> findByMobileNo(long mobileNo);

}
