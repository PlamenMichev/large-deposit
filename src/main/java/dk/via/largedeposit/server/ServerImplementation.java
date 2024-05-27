package dk.via.largedeposit.server;

import dk.via.largedeposit.database.dao.SqlUserDao;
import dk.via.largedeposit.model.User;
import dk.via.largedeposit.shared.ObserverEvents;
import dk.via.remote.observer.RemotePropertyChangeListener;
import dk.via.remote.observer.RemotePropertyChangeSupport;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServerImplementation implements Server {
    private final RemotePropertyChangeSupport<Serializable> support;

    public ServerImplementation() {
        this.support = new RemotePropertyChangeSupport<>();
    }

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

    @Override
    public ArrayList<User> getUsers() throws RemoteException {
        try {
            return SqlUserDao.getInstance().getUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void toggleUserActiveStatus(int id) throws RemoteException {
        try {
            SqlUserDao.getInstance().toggleUserActiveStatus(id);
            this.support.firePropertyChange(ObserverEvents.USER_ACTIVE_STATUS_TOGGLED, null, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addPropertyChangeListener(
            RemotePropertyChangeListener<Serializable> listener) throws RemoteException {
        this.support.addPropertyChangeListener(listener);
    }
}
