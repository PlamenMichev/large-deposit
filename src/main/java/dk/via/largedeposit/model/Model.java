package dk.via.largedeposit.model;

import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Interface for the model
 */
public interface Model {
    /**
     * Method used for the registration of a user
     * @param firstName first name of the user
     * @param lastName last name of the user
     * @param dob date of birth of the user
     * @param address address of the user
     * @param postalCode postal code of the user
     * @param city city of the user
     * @param phone phone number of the user
     * @param email email of the user
     * @param password password of the user
     * @param cpr cpr of the user
     * @return
     */
    User register(String firstName, String lastName, long dob, String address, String postalCode, String city, String phone, String email, String password, String cpr);

    /**
     * Method used for the registration of a user
     * @param email the email of the user
     * @param password the password of the user
     * @return
     */
    User login(String email, String password);

    /**
     * Getter for all users
     * @return all the users
     * @throws RemoteException
     */
    ArrayList<User> getUsers() throws RemoteException;

    /**
     * Getter for current user
     * @return current user
     */
    User getCurrentUser();

    /**
     * Toggler for activity status
     * @param id the id of the user
     */
    void toggleUserActiveStatus(int id);
    void addPropertyChangeListener(PropertyChangeListener listener);
}