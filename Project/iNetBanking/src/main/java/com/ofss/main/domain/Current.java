package com.ofss.main.domain;

public class Current extends Account {

    private double overdraftBalance;
    private double remainingOverdraftBalance;
    private double minimumBalance;

    public Current() {
    }

    public Current(Customer customer, String accountType) {
        super(customer, accountType);
    }

    public Current(int accountId, Customer customer, String accountType, double balance, double overdraftBalance,
            double remainingOverdraftBalance, double minimumBalance) {
        super(accountId, customer, accountType, balance);
        this.overdraftBalance = overdraftBalance;
        this.remainingOverdraftBalance = remainingOverdraftBalance;
        this.minimumBalance = minimumBalance;
    }

    public double getOverdraftBalance() {
        return overdraftBalance;
    }

    public double getRemainingOverdraftBalance() {
        return remainingOverdraftBalance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    @Override
    public String toString() {
        return "Current [overdraftBalance=" + overdraftBalance + ", remainingOverdraftBalance="
                + remainingOverdraftBalance + ", minimumBalance=" + minimumBalance + ", getAccountId()="
                + getAccountId() + ", getCustomer()=" + getCustomer() + ", getOverdraftBalance()="
                + getOverdraftBalance() + ", getRemainingOverdraftBalance()=" + getRemainingOverdraftBalance()
                + ", getAccountType()=" + getAccountType() + ", getMinimumBalance()=" + getMinimumBalance()
                + ", getBalance()=" + getBalance() + "]";
    }

}
