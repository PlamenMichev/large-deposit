package dk.via.largedeposit.model;

import dk.via.largedeposit.model.enums.Currency;

public class Account {
    private final String number;
    private String title;
    private final User user;
    private final String iban;
    private double balance;
    private final Currency currency;
    private boolean isActive;
    private int deactivationReason;
    private final long createdAt;

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

    public String getNumber() {
        return number;
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

    public boolean isActive() {
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
}