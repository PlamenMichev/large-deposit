package dk.via.largedeposit.database.dao;

import dk.via.largedeposit.database.DatabaseConnector;
import dk.via.largedeposit.model.User;
import dk.via.largedeposit.model.enums.UserRole;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * DAO for user info
 */
public class SqlUserDao implements UserDao {
    private static UserDao instance;
    private final DatabaseConnector dbConnector = new DatabaseConnector();

    /**
     * Constructor
     * @throws SQLException
     */
    private SqlUserDao() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }

    /**
     * Getter
     * @return instance of DAO
     * @throws SQLException
     */
    public synchronized static UserDao getInstance() throws SQLException {
        if (instance == null) {
            instance = new SqlUserDao();
        }

        return instance;
    }

    /**
     * Getter
     * @param email email of user
     * @param password password of user
     * @return the user with that specific email and password
     * @throws SQLException
     */
    @Override
    public User getByEmailAndPassword(String email, String password) throws SQLException {
        try (var connection = dbConnector.connect()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM bank.users WHERE email = ? AND password = ?");
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                return new User(
                        result.getString("cpr_number"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        UserRole.valueOf(result.getInt("role")),
                        result.getString("address"),
                        result.getString("postal_code"),
                        result.getString("city"),
                        result.getString("phone_number"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getBoolean("is_verified"),
                        result.getDate("date_of_birth").getTime(),
                        result.getDate("created_at").getTime()
                );
            } else {
                return null;
            }
        }
    }

    /**
     * Method used for registration
     * @param firstName first name of the user
     * @param lastName last name of the user
     * @param dateOfBirth date of birth of the user
     * @param address address of the user
     * @param postalCode postal code of the user
     * @param city city of the user
     * @param phone phone number of the user
     * @param email email of the user
     * @param password password of the user
     * @param cpr cpr of the user
     * @return new user with this details
     * @throws SQLException
     */
    @Override
    public User register(String firstName, String lastName, long dateOfBirth, String address, String postalCode, String city, String phone, String email, String password, String cpr) throws SQLException {
        try (var connection = dbConnector.connect()) {
            var currentTime = System.currentTimeMillis();
            PreparedStatement statement = connection.prepareStatement("INSERT INTO bank.users (first_name, last_name, date_of_birth, address, postal_code, city, phone_number, email, password, cpr_number, created_at, role, is_verified) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setDate(3, new Date(dateOfBirth));
            statement.setString(4, address);
            statement.setString(5, postalCode);
            statement.setString(6, city);
            statement.setString(7, phone);
            statement.setString(8, email);
            statement.setString(9, password);
            statement.setString(10, cpr);
            statement.setDate(11, new Date(currentTime));
            statement.setInt(12, UserRole.CUSTOMER.ordinal());
            statement.setBoolean(13, false);
            statement.executeUpdate();
            ResultSet keys = statement.getGeneratedKeys();
            keys.next();
            int id = keys.getInt(1);
            return new User(cpr, firstName, lastName, UserRole.CUSTOMER, address, postalCode, city, phone, email, password, false, dateOfBirth, currentTime);
        }
    }

    /**
     * Toggler for activity status
     * @param id the id of a user
     * @throws SQLException
     */
    @Override
    public void toggleUserActiveStatus(int id) throws SQLException {
        try (var connection = dbConnector.connect()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE bank.users SET is_verified = NOT is_verified WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    /**
     * Getter
     * @return all users
     * @throws SQLException
     */
    @Override
    public ArrayList<User> getUsers() throws SQLException {
        try (var connection = dbConnector.connect()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM bank.users");
            ResultSet result = statement.executeQuery();
            ArrayList<User> users = new ArrayList<>();
            while (result.next()) {
                users.add(new User(
                        result.getString("cpr_number"),
                        result.getString("first_name"),
                        result.getString("last_name"),
                        UserRole.valueOf(result.getInt("role")),
                        result.getString("address"),
                        result.getString("postal_code"),
                        result.getString("city"),
                        result.getString("phone_number"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getBoolean("is_verified"),
                        result.getDate("date_of_birth").getTime(),
                        result.getDate("created_at").getTime()
                ));
            }
            return users;
        }
    }
}
