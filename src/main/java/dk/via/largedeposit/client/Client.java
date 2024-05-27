package dk.via.largedeposit.client;

import dk.via.largedeposit.model.User;

import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Interface for the client
 */
public interface Client {

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
     * @throws RemoteException
     */
    User register(String firstName, String lastName, long dob, String address, String postalCode, String city, String phone, String email, String password, String cpr) throws RemoteException;

    /**
     * Method used for the registration of a user
     * @param email the email of the user
     * @param password the password of the user
     * @return
     * @throws RemoteException
     */
    User login(String email, String password) throws RemoteException;

    /**
     * Getter for all users
     * @return all the users
     * @throws RemoteException
     */
    ArrayList<User> getUsers() throws RemoteException;

    /**
     *Toggler for activity status
     * @param id the id of the user
     * @throws RemoteException
     */
    void toggleUserActiveStatus(int id) throws RemoteException;
    void addPropertyChangeListener(PropertyChangeListener listener);
}
