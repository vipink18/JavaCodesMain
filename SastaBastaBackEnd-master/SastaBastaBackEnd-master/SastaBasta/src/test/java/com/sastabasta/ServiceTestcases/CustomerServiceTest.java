package com.sastabasta.ServiceTestcases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sastabasta.entities.Customer;

import com.sastabasta.exceptions.EmailAlreadyRegisteredException;

import com.sastabasta.exceptions.MobileNumberAlreadyExistsException;
import com.sastabasta.repository.CustomerRepository;
import com.sastabasta.service.CustomerService;

@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	private CustomerService customerService;

	@MockBean
	private CustomerRepository customerRepository;

	private Customer customer;

	private Customer customer1;

	@BeforeEach
	public void customerServiceTestSetup() {
		customer = new Customer(1, "Deepali", 7440378897L, "deepali@gmail.com", "1234rgfsh");
		customer1 = new Customer(2, "xyz", 7443378897L, "xyz@gmail.com", "12rgfsuuh");
	}

	@Test
	public void addCustomerTest() throws EmailAlreadyRegisteredException, MobileNumberAlreadyExistsException {
		Mockito.when(customerRepository.save(customer)).thenReturn(customer);

		assertThat(customerService.addCustomer(customer)).isEqualTo(customer);
	}

	@Test
	public void getAllCustomersTest() {
		List<Customer> customerList = new ArrayList<>();

		customerList.add(customer);
		customerList.add(customer1);

		Mockito.when(customerRepository.findAll()).thenReturn(customerList);

		assertThat(customerService.findAllCustomer()).isEqualTo(customerList);
	}

	@Test
	public void updateCustomerTest() {
		Mockito.when(customerRepository.save(customer)).thenReturn(customer);

		Mockito.when(customerRepository.findById(1)).thenReturn(Optional.of(customer));


		customer.setCustName("Deepali Kosta");

		Customer result = customerService.editCustomer(customer);

		assertEquals("Deepali Kosta", result.getCustName());
		assertEquals("deepali@gmail.com", result.getEmail());
		assertEquals(7440378897L, result.getMobileNo());
		assertEquals("1234rgfsh", result.getPassword());
	}

	@Test
	public void getCustomerByIdTest() {

		Mockito.when(customerRepository.findById(1)).thenReturn(Optional.of(customer));

		assertThat(customerService.getCustomerById(1)).isEqualTo(Optional.of(customer));
	}

	@Test
	public void deleteCustomerByIdTest() {
		Mockito.when(customerRepository.findById(1)).thenReturn(Optional.of(customer));

		Mockito.doNothing().when(customerRepository).deleteById(1);

		customerService.deleteById(1);

		verify(customerRepository, times(1)).deleteById(1);

	}
}
