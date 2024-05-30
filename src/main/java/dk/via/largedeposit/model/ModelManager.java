package dk.via.largedeposit.model;

import dk.via.largedeposit.client.Client;
import javafx.application.Platform;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ModelManager implements Model, PropertyChangeListener {
    private final PropertyChangeSupport support;
    private final Client client;

    public ModelManager(Client client) {
        this.support = new PropertyChangeSupport(this);
        this.client = client;
        this.client.addPropertyChangeListener(this);
    }

    @Override
    public User register(String firstName, String lastName, long dob, String address, String postalCode, String city, String phone, String email, String password, String cpr) {
        try
        {
            return this.client.register(firstName, lastName, dob, address, postalCode, city, phone, email, password, cpr);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User login(String email, String password) {
        try
        {
            return this.client.login(email, password);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<User> getUsers() throws RemoteException {
        return this.client.getUsers();
    }

    @Override
    public User getCurrentUser() {
        return null;
    }

    @Override
    public void toggleUserActiveStatus(int id) {
        try
        {
            this.client.toggleUserActiveStatus(id);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Account> getAccounts() {
        try {
            return this.client.getAccounts();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account createAccount(String type, String name, String currency, User user) {
        try {
            return this.client.createAccount(type, name, currency, user);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() -> support.firePropertyChange(evt.getPropertyName(), evt.getOldValue(), evt.getNewValue()));
    }
}
