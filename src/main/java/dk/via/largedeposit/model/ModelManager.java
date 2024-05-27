package dk.via.largedeposit.model;

import dk.via.largedeposit.client.Client;
import javafx.application.Platform;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Model Manager for the app
 */
public class ModelManager implements Model, PropertyChangeListener {
    private final PropertyChangeSupport support;
    private final Client client;

    /**
     * Constructor
     * @param client the client
     */
    public ModelManager(Client client) {
        this.support = new PropertyChangeSupport(this);
        this.client = client;
        this.client.addPropertyChangeListener(this);
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
     */
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

    /**
     * Method used for the registration of a user
     * @param email the email of the user
     * @param password the password of the user
     * @return
     */
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

    /**
     * Getter for all users
     * @return all the users
     * @throws RemoteException
     */
    @Override
    public ArrayList<User> getUsers() throws RemoteException {
        return this.client.getUsers();
    }

    /**
     * Getter for current user
     * @return current user
     */
    @Override
    public User getCurrentUser() {
        return null;
    }

    /**
     * Toggler for activity status
     * @param id the id of the user
     */
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
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() -> support.firePropertyChange(evt.getPropertyName(), evt.getOldValue(), evt.getNewValue()));
    }
}
