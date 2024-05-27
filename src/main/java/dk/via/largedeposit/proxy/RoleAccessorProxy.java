package dk.via.largedeposit.proxy;

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

public class RoleAccessorProxy extends UnicastRemoteObject implements Model {
    private final Model delegate;
    private User currentUser;

    public RoleAccessorProxy(Model delegate) throws RemoteException {
        this.delegate = delegate;
        this.currentUser = null;
    }

    @Override
    public User register(String firstName, String lastName, long dob, String address, String postalCode, String city, String phone, String email, String password, String cpr) {
        if (currentUser != null) {
            throw new IllegalStateException("You are already logged in");
        }

        this.currentUser = delegate.register(firstName, lastName, dob, address, postalCode, city, phone, email, password, cpr);
        return this.currentUser;
    }

    @Override
    public User login(String email, String password) {
        if (currentUser != null) {
            throw new IllegalStateException("You are already logged in");
        }

        System.out.println("Login in proxy");
        this.currentUser = delegate.login(email, password);
        return this.currentUser;
    }

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

    @Override
    public User getCurrentUser() {
        return this.currentUser;
    }

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
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        delegate.addPropertyChangeListener(listener);
    }
}
