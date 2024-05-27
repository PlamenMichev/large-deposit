package dk.via.largedeposit.database.dao;

import dk.via.largedeposit.database.DatabaseConnector;
import dk.via.largedeposit.model.Account;
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
            var statement = connection.prepareStatement("SELECT * FROM accounts");
            var result = statement.executeQuery();
            var accounts = new ArrayList<Account>();
            while (result.next()) {
                accounts.add(new Account(
                        result.getString("number"),
                        result.getString("title"),
                        null,
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
}
