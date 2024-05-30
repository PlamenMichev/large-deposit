package dk.via.largedeposit.model;

import dk.via.largedeposit.model.enums.Currency;

/**
 * Class used to store and manipulate the information about a credit account
 */
public class CreditAccount extends Account {

    /**
     * The lower limit for the credit
     */
    private double creditLimit;

    /**
     * Constructor
     * @param number Number of the account
     * @param title Title of the account
     * @param user User of the account
     * @param iban Iban of the account
     * @param balance Balance of the account
     * @param currency Currency of the account
     * @param isActive Activity status of the account
     * @param deactivationReason Deactivation reason of the account
     * @param createdAt Creation date of the account
     */
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

    /**
     *
     * @param number Number of the account
     * @param title Title of the account
     * @param user User of the account
     * @param iban Iban of the account
     * @param balance Balance of the account
     * @param currency Currency of the account
     * @param isActive Activity status of the account
     * @param deactivationReason Deactivation reason of the account
     * @param createdAt Creation date of the account
     * @param creditLimit The lower limit for the credit
     */
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

    /**
     * Getter
     * @return the credit limit
     */
    public double getCreditLimit() {
        return creditLimit;
    }

    /**
     * Setter
     * @param creditLimit the credit limit
     */
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public String getType() {
        return "Credit";
    }
}
