package dk.via.largedeposit.model;

import dk.via.largedeposit.model.enums.Currency;

public class SavingsAccount extends Account {
    private double interestRate;
    private int interestPaymentPeriodMonths;
    private long lastPaymentDate;


    public SavingsAccount(String accountNumber, String regNumber, String title, User user, String iban, double balance, Currency currency, boolean isActive, int deactivationReason, long createdAt,
                          double interestRate, int interestPaymentPeriodMonths, long lastPaymentDate) {
        super(accountNumber, regNumber, title, user, iban, balance, currency, isActive, deactivationReason, createdAt);
        this.interestRate = interestRate;
        this.interestPaymentPeriodMonths = interestPaymentPeriodMonths;
        this.lastPaymentDate = lastPaymentDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getInterestPaymentPeriodMonths() {
        return interestPaymentPeriodMonths;
    }

    public void setInterestPaymentPeriodMonths(int interestPaymentPeriodMonths) {
        this.interestPaymentPeriodMonths = interestPaymentPeriodMonths;
    }

    public long getLastPaymentDate() {
        return lastPaymentDate;
    }
}