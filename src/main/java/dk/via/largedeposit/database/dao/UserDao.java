package dk.via.largedeposit.database.dao;

import dk.via.largedeposit.model.User;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interface for the DAO for user info
 */
public interface UserDao {

    /**
     * Getter
     * @param email email of user
     * @param password password of user
     * @return the user with that specific email and password
     * @throws SQLException
     */
    User getByEmailAndPassword(String email, String password) throws SQLException;

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
    User register(String firstName, String lastName, long dateOfBirth, String address, String postalCode, String city, String phone, String email, String password, String cpr) throws SQLException;

    /**
     * Toggler for activity status
     * @param id the id of a user
     * @throws SQLException
     */
    void toggleUserActiveStatus(int id) throws SQLException;

    /**
     * Getter
     * @return all users
     * @throws SQLException
     */
    ArrayList<User> getUsers() throws SQLException;
}