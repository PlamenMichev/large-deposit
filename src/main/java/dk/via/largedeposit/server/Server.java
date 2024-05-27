package dk.via.largedeposit.server;

import dk.via.largedeposit.model.User;
import dk.via.remote.observer.RemotePropertyChangeListener;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Interface for the server side
 */
public interface Server extends Remote {
    /**
     * Method used when a user registers
     * @param firstName first name of user
     * @param lastName last name of user
     * @param dob date of birth of user
     * @param address address of user
     * @param postalCode postal code of user
     * @param city city of user
     * @param phone phone number of user
     * @param email email of user
     * @param password password of user
     * @param cpr cpr of user
     * @return the response coming from user
     * @throws RemoteException
     */
    User register(String firstName, String lastName, long dob, String address, String postalCode, String city, String phone, String email, String password, String cpr) throws RemoteException;
    /**
     * Method used when a user logs in
     * @param email the email of the user
     * @param password the password of the user
     * @return the response coming from the user
     * @throws RemoteException
     */
    User login(String email, String password) throws RemoteException;
    /**
     * Getter
     * @return all users
     * @throws RemoteException
     */
    ArrayList<User> getUsers() throws RemoteException;
    /**
     * Toggler for the activity status
     * @param id the id of an user
     * @throws RemoteException
     */
    void toggleUserActiveStatus(int id) throws RemoteException;
    void addPropertyChangeListener(RemotePropertyChangeListener<Serializable> listener) throws RemoteException;
}
