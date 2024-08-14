package com.ofss.main.domain;

public class FixedDeposit {
    private int fixedDepositId;
    private double amount;
    private double maturityAmount;
    private FixedDepositValidityInterest fixedDepositValidityInterest;

    public FixedDeposit() {
    }

    public FixedDeposit(int fixedDepositId, double amount, double maturityAmount,
            FixedDepositValidityInterest fixedDepositValidityInterest) {
        this.fixedDepositId = fixedDepositId;
        this.amount = amount;
        this.maturityAmount = maturityAmount;
        this.fixedDepositValidityInterest = fixedDepositValidityInterest;
    }

    public int getFixedDepositId() {
        return fixedDepositId;
    }

    public void setFixedDepositId(int fixedDepositId) {
        this.fixedDepositId = fixedDepositId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getMaturityAmount() {
        return maturityAmount;
    }

    public void setMaturityAmount(double maturityAmount) {
        this.maturityAmount = maturityAmount;
    }

    public FixedDepositValidityInterest getFixedDepositValidityInterest() {
        return fixedDepositValidityInterest;
    }

    public void setFixedDepositValidityInterest(FixedDepositValidityInterest fixedDepositValidityInterest) {
        this.fixedDepositValidityInterest = fixedDepositValidityInterest;
    }

    @Override
    public String toString() {
        return "FixedDeposit [fixedDepositId=" + fixedDepositId + ", amount=" + amount + ", maturityAmount="
                + maturityAmount + ", fixedDepositValidityInterest=" + fixedDepositValidityInterest + "]";
    }

}
