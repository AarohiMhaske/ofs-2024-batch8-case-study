package com.ofss.main.domain;

import java.time.LocalDateTime;

public class Transactions {
    private int transactionId;
    private Account fromAccount;
    private Account toAccount;
    private String transactionType;
    private LocalDateTime transactionDateTime;

    public Transactions() {
    }

    public Transactions(int transactionId, Account fromAccount, Account toAccount, String transactionType,
            LocalDateTime transactionDateTime) {
        this.transactionId = transactionId;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.transactionType = transactionType;
        this.transactionDateTime = transactionDateTime;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(LocalDateTime transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    @Override
    public String toString() {
        return "Transactions [transactionId=" + transactionId + ", fromAccount=" + fromAccount + ", toAccount="
                + toAccount + ", transactionType=" + transactionType + ", transactionDateTime=" + transactionDateTime
                + "]";
    }

}
