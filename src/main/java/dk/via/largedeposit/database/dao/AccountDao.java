package dk.via.largedeposit.database.dao;

import dk.via.largedeposit.model.Account;
import dk.via.largedeposit.model.User;

import java.util.ArrayList;

public interface AccountDao {
    ArrayList<Account> getAccounts();
    Account createAccount(String type, String regNumber, String accountNumber, String title, String iban, String currency, double interestRate, int interestPaymentPeriodMonths, long lastPaymentDate, User user);
}

