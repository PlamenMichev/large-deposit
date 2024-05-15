package dk.via.largedeposit.model;

public class Transaction {
    private int id;
    private double amount;
    private long createdAt;
    private User createdBy;
    private Account sendingAccount;
    private Account receivingAccount;
    private boolean isApproved;
    private User approvedBy;
    private String status;

    public Transaction(int id, double amount, long createdAt, User createdBy, Account sendingAccount, Account receivingAccount, boolean isApproved, User approvedBy, String status) {
        this.id = id;
        this.amount = amount;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.sendingAccount = sendingAccount;
        this.receivingAccount = receivingAccount;
        this.isApproved = isApproved;
        this.approvedBy = approvedBy;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public Account getSendingAccount() {
        return sendingAccount;
    }

    public Account getReceivingAccount() {
        return receivingAccount;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public User getApprovedBy() {
        return approvedBy;
    }

    public String getStatus() {
        return status;
    }
}