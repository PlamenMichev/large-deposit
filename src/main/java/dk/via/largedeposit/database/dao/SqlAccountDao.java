package dk.via.largedeposit.database.dao;

import dk.via.largedeposit.database.DatabaseConnector;
import dk.via.largedeposit.model.Account;
import dk.via.largedeposit.model.CreditAccount;
import dk.via.largedeposit.model.SavingsAccount;
import dk.via.largedeposit.model.User;
import dk.via.largedeposit.model.enums.Currency;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class SqlAccountDao implements AccountDao {
    private static AccountDao instance;
    private final DatabaseConnector dbConnector = new DatabaseConnector();

    public SqlAccountDao() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    public synchronized static AccountDao getInstance() throws SQLException {
        if (instance == null) {
            instance = new SqlAccountDao();
        }

        return instance;
    }

    @Override
    public ArrayList<Account> getAccounts() {
        try (var connection = dbConnector.connect()) {
            var statement = connection.prepareStatement("SELECT * FROM bank.accounts");
            var result = statement.executeQuery();
            var accounts = new ArrayList<Account>();
            while (result.next()) {
                accounts.add(new Account(
                        result.getString("number"),
                        result.getString("registration"),
                        result.getString("title"),
                        new User(result.getInt("user_id"), "", "", "", null, "", "", "", "", "", "", false, 0, 0),
                        result.getString("iban"),
                        result.getDouble("balance"),
                        Currency.valueOf(result.getInt("currency")),
                        result.getBoolean("is_active"),
                        result.getInt("deactivation_reason"),
                        result.getDate("created_at").getTime())
                );
            }
            return accounts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account createAccount(String type, String regNumber, String accountNumber, String title, String iban, String currency, double interestRate, int interestPaymentPeriodMonths, long lastPaymentDate, User user) {
        try (var connection = dbConnector.connect()) {
            if (type.equals("Savings")) {
                var statement = connection.prepareStatement("INSERT INTO bank.savings_accounts (number, title, iban, currency, interest_rate, interest_payment_period_months, last_payment_date, created_at, user_id, registration) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                statement.setString(1, accountNumber);
                statement.setString(2, title);
                statement.setString(3, iban);
                statement.setInt(4, Currency.valueOf(currency).ordinal());
                statement.setDouble(5, interestRate);
                statement.setInt(6, interestPaymentPeriodMonths);
                statement.setDate(7, new java.sql.Date(lastPaymentDate));
                statement.setDate(8, new java.sql.Date(System.currentTimeMillis()));
                statement.setInt(9, user.getId());
                statement.setString(10, regNumber);
                statement.executeUpdate();
                return new SavingsAccount(accountNumber, regNumber, title, user, iban, 0, Currency.valueOf(currency), true, 0, System.currentTimeMillis(), interestRate, interestPaymentPeriodMonths, lastPaymentDate);
            } else if (type.equals("Credit")) {
                var statement = connection.prepareStatement("INSERT INTO bank.credit_accounts (number, title, iban, currency, created_at, user_id, registration) VALUES (?, ?, ?, ?, ?, ?, ?)");
                statement.setString(1, accountNumber);
                statement.setString(2, title);
                statement.setString(3, iban);
                statement.setInt(4, Currency.valueOf(currency).ordinal());
                statement.setDate(5, new java.sql.Date(System.currentTimeMillis()));
                statement.setInt(6, user.getId());
                statement.setString(7, regNumber);
                statement.executeUpdate();
                return new CreditAccount(accountNumber, regNumber, title, user, iban, 0, Currency.valueOf(currency), true, 0, System.currentTimeMillis(), 3500);
            } else {
                var statement = connection.prepareStatement("INSERT INTO bank.accounts (number, title, iban, currency, created_at, user_id, registration) VALUES (?, ?, ?, ?, ?, ?, ?)");
                statement.setString(1, accountNumber);
                statement.setString(2, title);
                statement.setString(3, iban);
                statement.setInt(4, Currency.valueOf(currency).ordinal());
                statement.setDate(5, new java.sql.Date(System.currentTimeMillis()));
                statement.setInt(6, user.getId());
                statement.setString(7, regNumber);
                statement.executeUpdate();
                return new Account(accountNumber, regNumber, title, user, iban, 0, Currency.valueOf(currency), true, 0, System.currentTimeMillis());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
