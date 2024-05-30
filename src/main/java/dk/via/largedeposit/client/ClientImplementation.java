package dk.via.largedeposit.client;

import dk.via.largedeposit.model.Account;
import dk.via.largedeposit.model.User;
import dk.via.largedeposit.server.Server;
import dk.via.remote.observer.RemotePropertyChangeEvent;
import dk.via.remote.observer.RemotePropertyChangeListener;
import javafx.application.Platform;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Implementation of the client
 */
public class ClientImplementation extends UnicastRemoteObject implements
        RemotePropertyChangeListener<Serializable>, Client {
    private final Server server;
    private final PropertyChangeSupport support;

    /**
     * Constructor
     * @param server the server
     * @throws RemoteException
     */
    public ClientImplementation(Server server) throws RemoteException {
        super(0);
        this.server = server;
        this.server.addPropertyChangeListener(this);
        this.support = new PropertyChangeSupport(this);
    }

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
    @Override
    public User register(String firstName, String lastName, long dob, String address, String postalCode, String city, String phone, String email, String password, String cpr) throws RemoteException {
        return this.server.register(firstName, lastName, dob, address, postalCode, city, phone, email, password, cpr);
    }

    /**
     * Method used for the registration of a user
     * @param email the email of the user
     * @param password the password of the user
     * @return
     * @throws RemoteException
     */
    @Override
    public User login(String email, String password) throws RemoteException {
        return this.server.login(email, password);
    }

    /**
     * Getter for all users
     * @return all the users
     * @throws RemoteException
     */
    @Override
    public ArrayList<User> getUsers() throws RemoteException {
        return this.server.getUsers();
    }

    /**
     *Toggler for activity status
     * @param id the id of the user
     * @throws RemoteException
     */
    @Override
    public void toggleUserActiveStatus(int id) throws RemoteException {
        this.server.toggleUserActiveStatus(id);
    }

    @Override
    public ArrayList<Account> getAccounts() throws RemoteException {
        return this.server.getAccounts();
    }

    @Override
    public Account createAccount(String type, String name, String currency, User user) throws RemoteException {
        return this.server.createAccount(type, name, currency, user);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void propertyChange(RemotePropertyChangeEvent<Serializable> evt) throws RemoteException {
        Platform.runLater(() -> support.firePropertyChange(evt.getPropertyName(), evt.getOldValue(), evt.getNewValue()));
    }
}
