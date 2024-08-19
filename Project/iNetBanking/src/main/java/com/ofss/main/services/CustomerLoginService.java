package com.ofss.main.services;

import org.springframework.stereotype.Service;

import com.ofss.main.domain.Login;

@Service
public interface CustomerLoginService {
	Login createNewLogin(Login login);
	Login getLoginCreds(int login_id);
	Login loginExisting(int loginId, String password);
}
