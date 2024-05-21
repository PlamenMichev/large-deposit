package dk.via.largedeposit.proxy;

import dk.via.largedeposit.model.Model;
import dk.via.largedeposit.model.ModelManager;
import dk.via.largedeposit.model.User;
import dk.via.largedeposit.server.Server;
import dk.via.largedeposit.shared.ObserverEvents;
import dk.via.remote.observer.RemotePropertyChangeListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RoleAccessorProxy extends UnicastRemoteObject implements Model, PropertyChangeListener {
    private final Model delegate;
    private User currentUser;

    public RoleAccessorProxy(Model delegate) throws RemoteException {
        this.delegate = delegate;
        this.delegate.addPropertyChangeListener(this);
        this.currentUser = null;
    }

    @Override
    public void register(String firstName, String lastName, long dob, String address, String postalCode, String city, String phone, String email, String password, String cpr) {
        if (currentUser != null) {
            throw new IllegalStateException("You are already logged in");
        }

        delegate.register(firstName, lastName, dob, address, postalCode, city, phone, email, password, cpr);
    }

    @Override
    public void login(String email, String password) {
        if (currentUser != null) {
            throw new IllegalStateException("You are already logged in");
        }

        System.out.println("Login in proxy");
        delegate.login(email, password);
    }

    @Override
    public User getCurrentUser() {
        return this.currentUser;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        delegate.addPropertyChangeListener(listener);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(ObserverEvents.USER_CREATED) || evt.getPropertyName().equals(ObserverEvents.USER_LOGGED_IN)) {
            currentUser = (User) evt.getNewValue();
        }
    }
}
