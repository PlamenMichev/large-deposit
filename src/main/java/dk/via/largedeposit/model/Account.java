package dk.via.largedeposit.model;

import dk.via.largedeposit.model.enums.Currency;

import java.io.Serializable;

public class Account implements Serializable {
    private final String accountNumber;
    private final String regNumber;
    private String title;
    private final User user;
    private final String iban;
    private double balance;
    private final Currency currency;
    private boolean isActive;
    private int deactivationReason;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIban() {
        return iban;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getDeactivationReason() {
        return deactivationReason;
    }

    public void setDeactivationReason(int deactivationReason) {
        this.deactivationReason = deactivationReason;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }

    public String getType() {
        return "Debit";
    }
}