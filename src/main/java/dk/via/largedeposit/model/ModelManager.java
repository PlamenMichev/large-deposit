package dk.via.largedeposit.model;

import dk.via.largedeposit.client.Client;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;

public class ModelManager implements Model, PropertyChangeListener {
    private final PropertyChangeSupport support;
    private final Client client;

    public ModelManager(Client client) {
        this.support = new PropertyChangeSupport(this);
        this.client = client;
        this.client.addPropertyChangeListener(this);
    }

    @Override
    public void register(String firstName, String lastName, long dob, String address, String postalCode, String city, String phone, String email, String password, String cpr) {
        try
        {
            this.client.register(firstName, lastName, dob, address, postalCode, city, phone, email, password, cpr);
        }
        catch (RemoteException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        support.firePropertyChange(evt);
    }
}
