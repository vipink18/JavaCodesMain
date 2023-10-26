package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.exceptions.EmployeeException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	EmployeeRepository er;
	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return er.save(emp);
	}

	@Override
	public Employee getEmployeeById(int id) throws EmployeeException {
		// TODO Auto-generated method stub
		Employee e =  er.findById(id).get();
		if(e == null) {
			throw new EmployeeException("Employee not found");
		}
		return e;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return er.findAll();
	}

	@Override
	public Employee findByName(String name) throws EmployeeException {
		// TODO Auto-generated method stub
		Employee e =  er.findByName(name);
		if(e == null) {
			throw new EmployeeException("Employee not found");
		}
		return e;
	}

	@Override
	public Employee deleteEmployee(int id) throws EmployeeException {
		// TODO Auto-generated method stub
		Employee e = null;
		if(!er.existsById(id)) {
			throw new EmployeeException("Emp not found");
		}
		e = er.findById(id).get();
		er.deleteById(id);
		return e;
	}

}
