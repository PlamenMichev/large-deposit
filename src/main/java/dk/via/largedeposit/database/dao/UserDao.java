package dk.via.largedeposit.database.dao;

import dk.via.largedeposit.model.User;
import java.sql.SQLException;


public interface UserDao {
    User register(String firstName, String lastName, long dateOfBirth, String address, String postalCode, String city, String phone, String email, String password, String cpr) throws SQLException;
}