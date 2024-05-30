package dk.via.largedeposit.model;

import dk.via.largedeposit.model.enums.Currency;

import java.io.Serializable;

public class Account implements Serializable {
    private final String accountNumber;
    private final String regNumber;
    private String title;
    /**
     * User of the account
     */
    private final User user;
    /**
     * Iban of the account
     */
    private final String iban;
    /**
     * Balance of the account
     */
    private double balance;
    /**
     * Currency of the account
     */
    private final Currency currency;
    /**
     * Activity status of the account
     */
    private boolean isActive;
    /**
     * Deactivation reason of the account
     */
    private int deactivationReason;
    /**
     * Creation date of the account
     */
    private final long createdAt;

    public Account(
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
        this.accountNumber = accountNumber;
        this.regNumber = regNumber;
        this.title = title;
        this.user = user;
        this.iban = iban;
        this.balance = balance;
        this.currency = currency;
        this.isActive = isActive;
        this.deactivationReason = deactivationReason;
        this.createdAt = createdAt;
    }

    /**
     * Getter
     * @return number of the account
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getRegNumber() {
        return regNumber;
    }

    /**
     * Getter
     * @return title of the account
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter
     * @param title title of the account
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter
     * @return iban of the account
     */
    public String getIban() {
        return iban;
    }

    /**
     * Getter
     * @return balance of the account
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Setter
     * @param balance balance of the account
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Getter
     * @return currency of the account
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * Getter
     * @return activity status of the account
     */
    public boolean getIsActive() {
        return isActive;
    }

    /**
     * Setter
     * @param active activity status of the account
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * Getter
     * @return deactivation reason status of the account
     */
    public int getDeactivationReason() {
        return deactivationReason;
    }

    /**
     * Setter
     * @param deactivationReason deactivation reason of the account
     */
    public void setDeactivationReason(int deactivationReason) {
        this.deactivationReason = deactivationReason;
    }

    /**
     * Getter
     * @return creation date of the account
     */
    public long getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter
     * @return user of the account
     */
    public User getUser() {
        return user;
    }

    public String getType() {
        return "Debit";
    }
}