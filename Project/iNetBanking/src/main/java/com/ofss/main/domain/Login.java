package com.ofss.main.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="login_details")
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="login_id")
    private int loginId;
	@Column(name="password")
    private String password;
	@Column(name="login_attempts")
    private int loginAttempts;
	@Column(name="login_status")
    private String loginStatus;
    
    public Login() {

    }

    public Login(String password) {
        this.password = password;
    }

    public Login(int loginId, String password, int loginAttempts, String loginStatus) {
        this.loginId = loginId;
        this.password = password;
        this.loginAttempts = loginAttempts;
        this.loginStatus = loginStatus;
    }

    public int getLoginId() {
        return loginId;
    }

    public void setLoginId(int loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(int loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }

    @Override
    public String toString() {
        return "Login [loginId=" + loginId + ", password=" + password + ", loginAttempts=" + loginAttempts
                + ", loginStatus=" + loginStatus + "]";
    }

}
