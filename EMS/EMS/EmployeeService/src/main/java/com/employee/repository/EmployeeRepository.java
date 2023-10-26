package com.employee.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;
import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer>  {

	Employee findByName(String name);
}
