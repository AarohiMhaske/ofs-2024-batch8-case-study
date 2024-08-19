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

//url - http://localhost:8080/login/existing

@RequestMapping("login")
@RestController
public class CustomerLoginController {
	
	@Autowired
	private CustomerLoginService customerLoginService;
	
	@PostMapping("create")
	public Login createLogin(@RequestBody Login login) {
		return customerLoginService.createNewLogin(login);
	}
	
    
	@PostMapping("existing")
    public ResponseEntity<?> loginExisting(@RequestParam int loginId, @RequestParam String password) {
        // Call the login service
        Login login = customerLoginService.loginExisting(loginId, password);

        if (login == null) {
            // Handle case where login entry is not found
            return ResponseEntity.status(404).body("Login entry not found.");
        }

        // Handle various login statuses
        switch (login.getLoginStatus()) {
            case "NEW":
                return ResponseEntity.ok("Account created. Please activate your account.");
            case "LOCKED":
                return ResponseEntity.status(403).body("Account is locked.");
            case "ACTIVE":
                return ResponseEntity.ok(login); // Return login details or success response
            default:
                return ResponseEntity.status(400).body("Unexpected login status.");
        }
	}
    
    @GetMapping("details/{login_id}")
    public Login getLoginDetails(@PathVariable int login_id) {
        return customerLoginService.getLoginCreds(login_id);
    }
	
}
