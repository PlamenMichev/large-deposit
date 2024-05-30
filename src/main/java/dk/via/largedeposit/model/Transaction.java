package dk.via.largedeposit.model;

/**
 * Class used to store and manipulate the information about a transaction
 */
public class Transaction {
    /**
     * The id of the transaction
     */
    private int id;
    /**
     * The amount of the transaction
     */
    private double amount;
    /**
     * The creation time of the transaction
     */
    private long createdAt;
    /**
     * The creator of the transaction
     */
    private User createdBy;
    /**
     * The sending account of the transaction
     */
    private Account sendingAccount;
    /**
     * The receiving account of the transaction
     */
    private Account receivingAccount;
    /**
     * The approval status of the transaction
     */
    private boolean isApproved;
    /**
     * The admin approving the transaction
     */
    private User approvedBy;
    /**
     * The status of the transaction
     */
    private String status;

    /**
     * Constructor
     * @param id The id of the transaction
     * @param amount The amount of the transaction
     * @param createdAt The creation time of the transaction
     * @param createdBy The creator of the transaction
     * @param sendingAccount The sending account of the transaction
     * @param receivingAccount The receiving account of the transaction
     * @param isApproved The approval status of the transaction
     * @param approvedBy The admin approving the transaction
     * @param status The status of the transaction
     */
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

    /**
     * Getter
     * @return the id of the transaction
     */
    public int getId() {
        return id;
    }

    /**
     * Getter
     * @return the amount of the transaction
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Getter
     * @return the creation time of the transaction
     */
    public long getCreatedAt() {
        return createdAt;
    }

    /**
     * Getter
     * @return the creator of the transaction
     */
    public User getCreatedBy() {
        return createdBy;
    }

    /**
     * Getter
     * @return the sending account of the transaction
     */
    public Account getSendingAccount() {
        return sendingAccount;
    }

    /**
     * Getter
     * @return the receiving account of the transaction
     */
    public Account getReceivingAccount() {
        return receivingAccount;
    }

    /**
     * Getter
     * @return the approval status of the transaction
     */
    public boolean isApproved() {
        return isApproved;
    }

    /**
     * Getter
     * @return the admin approving the transaction
     */
    public User getApprovedBy() {
        return approvedBy;
    }

    /**
     * Getter
     * @return the status of the transaction
     */
    public String getStatus() {
        return status;
    }
}