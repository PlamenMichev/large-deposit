package dk.via.largedeposit.client;

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

public class ClientImplementation extends UnicastRemoteObject implements
        RemotePropertyChangeListener<Serializable>, Client {
    private final Server server;
    private final PropertyChangeSupport support;

    public ClientImplementation(Server server) throws RemoteException {
        super(0);
        this.server = server;
        this.server.addPropertyChangeListener(this);
        this.support = new PropertyChangeSupport(this);
    }
    @Override
    public User register(String firstName, String lastName, long dob, String address, String postalCode, String city, String phone, String email, String password, String cpr) throws RemoteException {
        return this.server.register(firstName, lastName, dob, address, postalCode, city, phone, email, password, cpr);
    }

    @Override
    public User login(String email, String password) throws RemoteException {
        return this.server.login(email, password);
    }

    @Override
    public ArrayList<User> getUsers() throws RemoteException {
        return this.server.getUsers();
    }

    @Override
    public void toggleUserActiveStatus(int id) throws RemoteException {
        this.server.toggleUserActiveStatus(id);
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
