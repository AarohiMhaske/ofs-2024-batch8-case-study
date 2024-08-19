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
	
	@Override
    public Login loginExisting(int loginId, String password) {
        // Fetch the login entry using loginId
        Login login = customerLoginRepository.findByloginId(loginId);
        if (login != null) {
            // Check login status
            switch (login.getLoginStatus()) {
                case "NEW":
                    login.setLoginStatus("ACTIVE"); // or another appropriate status transition
                    login.setLoginAttempts(0); // Reset attempts if needed
                    customerLoginRepository.save(login);
                    return login; // Return login details with updated status
                case "LOCKED":
                    // Handle locked status, e.g., returning a message or status code
                    return login; // or throw an exception, or return an appropriate error message
                case "ACTIVE":
                    // Check if the login attempts are less than the allowed limit
                    if (login.getLoginAttempts() < 3) {
                        if (login.getPassword().equals(password)) {
                            login.setLoginAttempts(0); // Reset attempts on successful login
                            customerLoginRepository.save(login);
                            return login; // Return login details for a successful login
                        } else {
                            // Increment login attempts
                            login.setLoginAttempts(login.getLoginAttempts() + 1);
                            if (login.getLoginAttempts() >= 3) {
                                login.setLoginStatus("LOCKED");
                            }
                            customerLoginRepository.save(login);
                            return login; // Return login details with updated attempts/status
                        }
                    } else {
                        // If attempts exceed the limit, return a LOCKED status
                        login.setLoginStatus("LOCKED");
                        customerLoginRepository.save(login);
                        return login;
                    }
                default:
                    // Handle any other statuses or errors
                    return login; // or throw an exception, or return an appropriate error message
            }
        } else {
            // Handle case where login entry is not found
            return null; // or throw an exception, or return an appropriate error message
        }
    }
}