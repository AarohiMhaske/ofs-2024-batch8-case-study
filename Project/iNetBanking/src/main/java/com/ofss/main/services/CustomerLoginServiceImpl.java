package com.ofss.main.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ofss.main.domain.Customer;
import com.ofss.main.domain.Login;
import com.ofss.main.repositories.CustomerLoginRepository;
import com.ofss.main.repositories.CustomerRegistration;

import jakarta.transaction.Transactional;

@Service
public class CustomerLoginServiceImpl implements CustomerLoginService {
	
	@Autowired
	private CustomerLoginRepository customerLoginRepository;
	
	@Autowired
	private CustomerRegistration customerRegistrationRepository;
	
	@Override
	public Login createNewLogin(Login login) {
		return customerLoginRepository.save(login);
	}

	@Override
	public Login getLoginCreds(int login_id) {
		Optional <Login> optional= customerLoginRepository.findById(login_id);
        if (optional.isPresent()) {
            return optional.get();
        }
		return null;
	}
	
	public static final int SUCCESS = 0;
    public static final int CUSTOMER_NOT_FOUND = -1;
    public static final int LOGIN_STATUS_NEW = -2;
    public static final int LOGIN_STATUS_LOCKED = -3;
    public static final int LOGIN_ATTEMPTS_EXCEEDED = -4;
    public static final int INVALID_PASSWORD = -5;
    public static final int UNKNOWN_ERROR = -6;
	
	@Transactional
	public int validateLogin(int customerId, String password) {
		try {
            // Fetch the customer record
            Customer customer = customerRegistrationRepository.findById(customerId)
                    .orElse(null); // Use Optional to handle potential nulls

            if (customer == null) {
                return CUSTOMER_NOT_FOUND;
            }

            // Fetch the login details for the customer
            Login login = customerLoginRepository.findByCustomerId(customer.getCustomerId());

            if (login == null) {
                return UNKNOWN_ERROR; // Or a more appropriate response
            }

            // Check login status and validate credentials
            switch (login.getLoginStatus()) {
                case "NEW":
                    return LOGIN_STATUS_NEW;
                case "LOCKED":
                    return LOGIN_STATUS_LOCKED;
                case "ACTIVE":
                    if (login.getLoginAttempts() >= 3) {
                        return LOGIN_ATTEMPTS_EXCEEDED;
                    }
                    if (login.getPassword().equals(password)) {
                        return SUCCESS;
                    } else {
                        // Increment login attempts
                    	customerLoginRepository.incrementLoginAttemptsByLoginId(login.getLoginId());
                        return INVALID_PASSWORD;
                    }
                default:
                    return UNKNOWN_ERROR;
            }
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return UNKNOWN_ERROR;
        }
    }
}