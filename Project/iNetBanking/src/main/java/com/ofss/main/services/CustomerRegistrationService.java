package com.ofss.main.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ofss.main.domain.Customer;

@Service
public interface CustomerRegistrationService {
	public Customer addNewCustomer(Customer customer);
	public Customer getCustomerByCustomerId(int customerId);
	public Customer updateExistingCustomer(Customer customer);
	public boolean deleteCustomerByCustomerId(int customerId);
	public List<Customer> getAllCustomers();
}
