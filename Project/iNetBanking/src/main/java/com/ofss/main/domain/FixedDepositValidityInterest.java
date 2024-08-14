package com.ofss.main.domain;

public class FixedDepositValidityInterest {
    private int fixedDepositValidityInterestId;
    private int validityInMonths;
    private double rateOfInterest;

    public FixedDepositValidityInterest() {
    }

    public FixedDepositValidityInterest(int fixedDepositValidityInterestId, int validityInMonths,
            double rateOfInterest) {
        this.fixedDepositValidityInterestId = fixedDepositValidityInterestId;
        this.validityInMonths = validityInMonths;
        this.rateOfInterest = rateOfInterest;
    }

    public int getFixedDepositValidityInterestId() {
        return fixedDepositValidityInterestId;
    }

    public void setFixedDepositValidityInterestId(int fixedDepositValidityInterestId) {
        this.fixedDepositValidityInterestId = fixedDepositValidityInterestId;
    }

    public int getValidityInMonths() {
        return validityInMonths;
    }

    public void setValidityInMonths(int validityInMonths) {
        this.validityInMonths = validityInMonths;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    @Override
    public String toString() {
        return "FixedDepositValiditInterest [fixedDepositValidityInterestId=" + fixedDepositValidityInterestId
                + ", validityInMonths=" + validityInMonths + ", rateOfInterest=" + rateOfInterest + "]";
    }

}
