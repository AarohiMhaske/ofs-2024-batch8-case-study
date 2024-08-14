package com.ofss.main.domain;

public class BankSlip {
    private int bankSlipId;
    private Cheque cheque;
    private Account account;

    public BankSlip() {
    }

    public BankSlip(int bankSlipId, Cheque cheque, Account account) {
        this.bankSlipId = bankSlipId;
        this.cheque = cheque;
        this.account = account;
    }

    public int getBankSlipId() {
        return bankSlipId;
    }

    public void setBankSlipId(int bankSlipId) {
        this.bankSlipId = bankSlipId;
    }

    public Cheque getCheque() {
        return cheque;
    }

    public void setCheque(Cheque cheque) {
        this.cheque = cheque;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "BankSlip [bankSlipId=" + bankSlipId + ", cheque=" + cheque + ", account=" + account + "]";
    }

}
