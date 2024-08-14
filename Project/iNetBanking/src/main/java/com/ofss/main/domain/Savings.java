package com.ofss.main.domain;

public class Savings extends Account {
    private double rateOfInterest;
    private double minimumBalance;

    
    public Savings() {
    }

    
    public Savings(Customer customer, String accountType) {
        super(customer, accountType);
    }

    public Savings(int accountId, Customer customer, String accountType, double balance, double rateOfInterest,
            double minimumBalance) {
        super(accountId, customer, accountType, balance);
        this.rateOfInterest = rateOfInterest;
        this.minimumBalance = minimumBalance;
    }


    public double getRateOfInterest() {
        return rateOfInterest;
    }


    public void setRateOfInterest(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }


    public double getMinimumBalance() {
        return minimumBalance;
    }


    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }


    @Override
    public String toString() {
        return "Savings [rateOfInterest=" + rateOfInterest + ", minimumBalance=" + minimumBalance + ", getAccountId()="
                + getAccountId() + ", getRateOfInterest()=" + getRateOfInterest() + ", getCustomer()=" + getCustomer()
                + ", getMinimumBalance()=" + getMinimumBalance() + ", getAccountType()=" + getAccountType()
                + ", getBalance()=" + getBalance() + "]";
    }


    
}
