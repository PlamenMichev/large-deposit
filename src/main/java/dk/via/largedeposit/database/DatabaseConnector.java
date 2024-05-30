package dk.via.largedeposit.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Connector for the database
 */
public class DatabaseConnector {
    /**
     * Connect function
     * @return
     * @throws SQLException
     */
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres?currentSchema=large-deposit",
                "postgres",
                "Plamen123");
    }
}
