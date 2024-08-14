package com.ofss.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Customer;
import com.ofss.main.repositories.CustomerRegistration;

@Service
public class CustomerRegistrationServiceImpl implements CustomerRegistrationService {
	
	@Autowired
	private CustomerRegistration customerRegistrationRepository;

	@Override
	public Customer addNewCustomer(Customer customer) {
		return customerRegistrationRepository.save(customer);
	}

	@Override
	public Customer getCustomerByCustomerId(int customerId) {
		Optional<Customer>customerOptional = customerRegistrationRepository.findById(customerId);
		if(customerOptional.isPresent()) {
			return customerOptional.get();
		}
		return null;
	}

	@Override
	public Customer updateExistingCustomer(Customer customer) {
		return customerRegistrationRepository.save(customer);
	}

	@Override
	public boolean deleteCustomerByCustomerId(int customerId) {
		Optional<Customer>customerOptional = customerRegistrationRepository.findById(customerId);
		if(customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			customerRegistrationRepository.delete(customer);
			return true;
		}
		return false;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> listOfCustomers = (List<Customer>) customerRegistrationRepository.findAll();
		return listOfCustomers;	}

}
