package dk.via.largedeposit.database.dao;

import dk.via.largedeposit.model.Account;

import java.util.ArrayList;

/**
 * Interface for the DAO for account info
 */
public interface AccountDao {
    /**
     * Getter
     * @return all accounts
     */
    ArrayList<Account> getAccounts();
}
