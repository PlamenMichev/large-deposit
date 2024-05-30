package dk.via.largedeposit.model;

import dk.via.largedeposit.model.enums.Currency;

public class CreditAccount extends Account {

    private double creditLimit;

    public CreditAccount(
            String accountNumber,
            String regNumber,
            String title,
            User user,
            String iban,
            double balance,
            Currency currency,
            boolean isActive,
            int deactivationReason,
            long createdAt) {
        super(accountNumber, regNumber, title, user, iban, balance, currency, isActive, deactivationReason, createdAt);
        this.creditLimit = 0;
    }

    public CreditAccount(
            String accountNumber,
            String regNumber,
            String title,
            User user,
            String iban,
            double balance,
            Currency currency,
            boolean isActive,
            int deactivationReason,
            long createdAt,
            double creditLimit) {
        super(accountNumber, regNumber, title, user, iban, balance, currency, isActive, deactivationReason, createdAt);
        this.creditLimit = creditLimit;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public String getType() {
        return "Credit";
    }
}
