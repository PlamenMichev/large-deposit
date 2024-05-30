package dk.via.largedeposit.proxy;

import dk.via.largedeposit.model.Account;
import dk.via.largedeposit.model.Model;
import dk.via.largedeposit.model.ModelManager;
import dk.via.largedeposit.model.User;
import dk.via.largedeposit.model.enums.UserRole;
import dk.via.largedeposit.server.Server;
import dk.via.largedeposit.shared.ObserverEvents;
import dk.via.remote.observer.RemotePropertyChangeListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * This class is the proxi for the server
 */
public class RoleAccessorProxy extends UnicastRemoteObject implements Model {
    private final Model delegate;
    private User currentUser;

    /**
     * Constructor
     * @param delegate the model
     * @throws RemoteException
     */
    public RoleAccessorProxy(Model delegate) throws RemoteException {
        this.delegate = delegate;
        this.currentUser = null;
    }

    /**
     * This method handles registration
     * @param firstName
     * @param lastName
     * @param dob
     * @param address
     * @param postalCode
     * @param city
     * @param phone
     * @param email
     * @param password
     * @param cpr
     * @return the user that registered
     */
    @Override
    public User register(String firstName, String lastName, long dob, String address, String postalCode, String city, String phone, String email, String password, String cpr) {
        if (currentUser != null) {
            throw new IllegalStateException("You are already logged in");
        }

        this.currentUser = delegate.register(firstName, lastName, dob, address, postalCode, city, phone, email, password, cpr);
        return this.currentUser;
    }

    /**
     * This method handles login
     * @param email
     * @param password
     * @return the user that logged in
     */
    @Override
    public User login(String email, String password) {
        if (currentUser != null) {
            throw new IllegalStateException("You are already logged in");
        }

        System.out.println("Login in proxy");
        this.currentUser = delegate.login(email, password);
        return this.currentUser;
    }

    /**
     * Getter
     * @return all users registered
     * @throws RemoteException
     */
    @Override
    public ArrayList<User> getUsers() throws RemoteException {
        if (currentUser == null) {
            throw new IllegalStateException("You are not logged in");
        }

        if (currentUser.getRole() != UserRole.ADMIN) {
            throw new IllegalArgumentException("You are not authorized to view users");
        }

        return delegate.getUsers();
    }

    /**
     * Getter
     * @return the specific user
     */
    @Override
    public User getCurrentUser() {
        return this.currentUser;
    }

    /**
     * This method is used to change the activity status of an user
     * @param id the id of the user
     */
    @Override
    public void toggleUserActiveStatus(int id) {
        if (currentUser == null) {
            throw new IllegalStateException("You are not logged in");
        }

        if (currentUser.getRole() != UserRole.ADMIN) {
            throw new IllegalArgumentException("You are not authorized to toggle user active status");
        }

        delegate.toggleUserActiveStatus(id);
    }

    @Override
    public ArrayList<Account> getAccounts() {
        if (currentUser == null) {
            throw new IllegalStateException("You are not logged in");
        }

        var result = delegate.getAccounts();
        if (currentUser.getRole() == UserRole.ADMIN) {
            return result;
        }

        return new ArrayList<>(result.stream()
                .filter(account -> account.getUser().getId() == currentUser.getId())
                .toList());
    }

    @Override
    public Account createAccount(String type, String name, String currency, User user) {
        if (currentUser == null) {
            throw new IllegalStateException("You are not logged in");
        }

        return delegate.createAccount(type, name, currency, currentUser);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        delegate.addPropertyChangeListener(listener);
    }
}
