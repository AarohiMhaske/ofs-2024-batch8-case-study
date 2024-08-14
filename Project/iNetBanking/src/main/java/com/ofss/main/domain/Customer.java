package com.ofss.main.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="customer_details")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
    private int customerId;
	@Column(name="first_name")
    private String firstName;
	@Column(name="last_name")
    private String lastName;
	@Column(name="gender")
    private String gneder;
	@Column(name="email")
    private String email;
	@Column(name="mobile")
    private String mobile;
	@Column(name="customer_status")
    private String customerStatus;
	
	@Transient
	@Column(name="login_id")
    private Login login;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String gneder, String email, String mobile,
            Login login) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gneder = gneder;
        this.email = email;
        this.mobile = mobile;
        this.login = login;
    }

    public Customer(int customerId, String firstName, String lastName, String gneder, String email, String mobile,
            Login login, String customerStatus) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gneder = gneder;
        this.email = email;
        this.mobile = mobile;
        this.login = login;
        this.customerStatus = customerStatus;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGneder() {
        return gneder;
    }

    public void setGneder(String gneder) {
        this.gneder = gneder;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", gneder=" + gneder + ", email=" + email + ", mobile=" + mobile + ", login=" + login
                + ", customerStatus=" + customerStatus + "]";
    }

}
