package dk.via.largedeposit.server;

import dk.via.largedeposit.database.dao.SqlAccountDao;
import dk.via.largedeposit.database.dao.SqlUserDao;
import dk.via.largedeposit.model.Account;
import dk.via.largedeposit.model.User;
import dk.via.largedeposit.shared.ObserverEvents;
import dk.via.remote.observer.RemotePropertyChangeListener;
import dk.via.remote.observer.RemotePropertyChangeSupport;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Implementation of the server
 */
public class ServerImplementation implements Server {
    private final RemotePropertyChangeSupport<Serializable> support;

    public ServerImplementation() {
        this.support = new RemotePropertyChangeSupport<>();
    }

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
    @Override
    public User register(String firstName, String lastName, long dob, String address, String postalCode, String city, String phone, String email, String password, String cpr) throws RemoteException {
        try {

            var userResponse = SqlUserDao.getInstance().register(firstName, lastName, dob, address, postalCode, city, phone, email, password, cpr);
            if (userResponse != null) {
                this.support.firePropertyChange(ObserverEvents.USER_CREATED, null, userResponse);
            }

            return userResponse;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method used when a user logs in
     * @param email the email of the user
     * @param password the password of the user
     * @return the response coming from the user
     * @throws RemoteException
     */
    @Override
    public User login(String email, String password) throws RemoteException {
        try {
            var userResponse = SqlUserDao.getInstance().getByEmailAndPassword(email, password);
            if (userResponse == null) {
                throw new RuntimeException("User not found");
            }

            this.support.firePropertyChange(ObserverEvents.USER_LOGGED_IN, null, userResponse);
            return userResponse;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Getter
     * @return all users
     * @throws RemoteException
     */
    @Override
    public ArrayList<User> getUsers() throws RemoteException {
        try {
            return SqlUserDao.getInstance().getUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Toggler for the activity status
     * @param id the id of an user
     * @throws RemoteException
     */
    @Override
    public void toggleUserActiveStatus(int id) throws RemoteException {
        try {
            SqlUserDao.getInstance().toggleUserActiveStatus(id);
            this.support.firePropertyChange(ObserverEvents.USER_ACTIVE_STATUS_TOGGLED, null, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Account> getAccounts() throws RemoteException {
        try {
            return SqlAccountDao.getInstance().getAccounts();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account createAccount(String type, String name, String currency, User user) throws RemoteException {
        try {
            // Here we generate the iban and the reg + account number
            var iban = "DK" + (int) (Math.random() * 1000000000);
            var reg = (int) (Math.random() * 10000);
            var accountNumber = (long) (Math.random() * 1000000000 * 100);
            var accountResponse = SqlAccountDao.getInstance().createAccount(type, String.valueOf(reg).substring(0, 3), String.valueOf(accountNumber).substring(0, 9), name, iban, currency,
                    2.4, 6, 0, user);
            if (accountResponse != null) {
                this.support.firePropertyChange(ObserverEvents.ACCOUNT_CREATED, null, accountResponse);
            }

            return accountResponse;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addPropertyChangeListener(
            RemotePropertyChangeListener<Serializable> listener) throws RemoteException {
        this.support.addPropertyChangeListener(listener);
    }
}
