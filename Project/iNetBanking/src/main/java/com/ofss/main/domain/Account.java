package com.ofss.main.domain;

import jakarta.persistence.Transient;

public class Account {
    private int accountId;
    private String accountType;
    private double balance;
    
    @Transient
    private Customer customer;

    public Account() {
    }

    public Account(Customer customer, String accountType) {
        this.customer = customer;
        this.accountType = accountType;
    }
    public Account(int accountId, Customer customer, String accountType, double balance) {
        this.accountId = accountId;
        this.customer = customer;
        this.accountType = accountType;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account [accountId=" + accountId + ", customer=" + customer + ", accountType=" + accountType
                + ", balance=" + balance + "]";
    }

}
