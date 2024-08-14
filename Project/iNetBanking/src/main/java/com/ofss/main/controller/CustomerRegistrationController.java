package com.ofss.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.domain.Customer;
import com.ofss.main.services.CustomerRegistrationService;

@CrossOrigin("*")
@RequestMapping("registration")
@RestController
public class CustomerRegistrationController {
	
	@Autowired
	private CustomerRegistrationService customerRegistrationService;
	
	//url - http://localhost:8080/registration/getcustomer/1
	
	@GetMapping("getcustomer/{customerId}")
	public Customer getCustomerFromDB(@PathVariable int customerId) {
		return customerRegistrationService.getCustomerByCustomerId(customerId);
	}
	
	@PostMapping("newcustomer")
	public Customer addNewCustomerToDB(@RequestBody Customer customer) {
		return customerRegistrationService.addNewCustomer(customer);
	}
	
	@PutMapping("updatecustomer")
	public Customer updateEmployeeToDB(@RequestBody Customer customer) {
		return customerRegistrationService.updateExistingCustomer(customer);
	}
	
	@DeleteMapping("deletecustomer/{customerId}")
	public boolean deleteCustomerFromDB(@PathVariable int customerId) {
		return customerRegistrationService.deleteCustomerByCustomerId(customerId);
	}
	
	@GetMapping("getallcustomers")
	public List<Customer> getAllCustomersFromDB(){
		return customerRegistrationService.getAllCustomers();
	}

}
