package com.ofss.main.domain;

import java.time.LocalDate;

public class Cheque {
    private int chequeId;
    private String receiverName;
    private LocalDate chequeDate;
    private double amount;
    private Account account;
    private String chequeStatus;

    public Cheque() {
    }

    public Cheque(int chequeId, String receiverName, LocalDate chequeDate, double amount, Account account,
            String chequeStatus) {
        this.chequeId = chequeId;
        this.receiverName = receiverName;
        this.chequeDate = chequeDate;
        this.amount = amount;
        this.account = account;
        this.chequeStatus = chequeStatus;
    }

    public int getChequeId() {
        return chequeId;
    }

    public void setChequeId(int chequeId) {
        this.chequeId = chequeId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public LocalDate getChequeDate() {
        return chequeDate;
    }

    public void setChequeDate(LocalDate chequeDate) {
        this.chequeDate = chequeDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getChequeStatus() {
        return chequeStatus;
    }

    public void setChequeStatus(String chequeStatus) {
        this.chequeStatus = chequeStatus;
    }

    @Override
    public String toString() {
        return "Cheque [chequeId=" + chequeId + ", receiverName=" + receiverName + ", chequeDate=" + chequeDate
                + ", amount=" + amount + ", account=" + account + ", chequeStatus=" + chequeStatus + "]";
    }

}
