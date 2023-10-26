package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
