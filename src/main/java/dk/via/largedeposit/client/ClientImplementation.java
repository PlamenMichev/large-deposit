package dk.via.largedeposit.client;

import dk.via.largedeposit.server.Server;
import dk.via.remote.observer.RemotePropertyChangeEvent;
import dk.via.remote.observer.RemotePropertyChangeListener;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
    public void register(String firstName, String lastName, long dob, String address, String postalCode, String city, String phone, String email, String password, String cpr) throws RemoteException {
        this.server.register(firstName, lastName, dob, address, postalCode, city, phone, email, password, cpr);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void propertyChange(RemotePropertyChangeEvent<Serializable> evt) throws RemoteException {
        support.firePropertyChange(evt.getPropertyName(), evt.getOldValue(), evt.getNewValue());
    }
}
