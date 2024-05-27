package dk.via.largedeposit.database.dao;

import dk.via.largedeposit.model.Account;

import java.util.ArrayList;

public interface AccountDao {
    ArrayList<Account> getAccounts();
}
