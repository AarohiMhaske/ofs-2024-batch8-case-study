package com.ofss.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.main.domain.Login;
import com.ofss.main.services.CustomerLoginService;
import com.ofss.main.services.CustomerLoginServiceImpl;

//url - http://localhost:8080/login/create

@RequestMapping("login")
@RestController
public class CustomerLoginController {
	
	@Autowired
	private CustomerLoginServiceImpl customerLoginService;
	
	@PostMapping("create")
	public Login createLogin(@RequestBody Login login) {
		return customerLoginService.createNewLogin(login);
	}
	
    
    @PostMapping("validate")
    public ResponseEntity<String> validateLogin(@RequestParam int customerId, @RequestParam String password) {
        int result = customerLoginService.validateLogin(customerId, password);

        switch (result) {
            case CustomerLoginServiceImpl.SUCCESS:
                return ResponseEntity.ok("Login successful!");
            case CustomerLoginServiceImpl.CUSTOMER_NOT_FOUND:
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found.");
            case CustomerLoginServiceImpl.LOGIN_STATUS_NEW:
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Account is new. Please complete initial setup.");
            case CustomerLoginServiceImpl.LOGIN_STATUS_LOCKED:
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Account is locked.");
            case CustomerLoginServiceImpl.LOGIN_ATTEMPTS_EXCEEDED:
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Maximum login attempts exceeded.");
            case CustomerLoginServiceImpl.INVALID_PASSWORD:
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password.");
            case CustomerLoginServiceImpl.UNKNOWN_ERROR:
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unknown error occurred.");
        }
    }
    
    @GetMapping("details/{login_id}")
    public Login getLoginDetails(@PathVariable int login_id) {
        return customerLoginService.getLoginCreds(login_id);
    }
	
}
