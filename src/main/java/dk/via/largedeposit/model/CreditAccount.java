package dk.via.largedeposit.model;

import dk.via.largedeposit.model.enums.Currency;

public class CreditAccount extends Account {

    private double creditLimit;

    public CreditAccount(
            String number,
            String title,
            User user,
            String iban,
            double balance,
            Currency currency,
            boolean isActive,
            int deactivationReason,
            long createdAt) {
        super(number, title, user, iban, balance, currency, isActive, deactivationReason, createdAt);
        this.creditLimit = 0;
    }

    public CreditAccount(
            String number,
            String title,
            User user,
            String iban,
            double balance,
            Currency currency,
            boolean isActive,
            int deactivationReason,
            long createdAt,
            double creditLimit) {
        super(number, title, user, iban, balance, currency, isActive, deactivationReason, createdAt);
        this.creditLimit = creditLimit;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
}


//// Inherits accounts
//Table credit_accounts {
//creditLimit decimal
//}
