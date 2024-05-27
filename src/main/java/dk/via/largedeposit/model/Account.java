package dk.via.largedeposit.model;

import dk.via.largedeposit.model.enums.Currency;

/**
 * Class used to store and manipulate the information about an account
 */
public class Account {
    /**
     * Number of the account
     */
    private final String number;
    /**
     * Title of the account
     */
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
    public Account(
            String number,
            String title,
            User user,
            String iban,
            double balance,
            Currency currency,
            boolean isActive,
            int deactivationReason,
            long createdAt) {
        this.number = number;
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
    public String getNumber() {
        return number;
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
    public boolean isActive() {
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
}