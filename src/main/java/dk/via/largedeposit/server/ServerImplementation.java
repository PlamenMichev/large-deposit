package dk.via.largedeposit.server;

import dk.via.largedeposit.database.dao.SqlUserDao;
import dk.via.largedeposit.model.User;
import dk.via.largedeposit.shared.ObserverEvents;
import dk.via.remote.observer.RemotePropertyChangeListener;
import dk.via.remote.observer.RemotePropertyChangeSupport;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.SQLException;

public class ServerImplementation implements Server {
    private final RemotePropertyChangeSupport<Serializable> support;

    public ServerImplementation() {
        this.support = new RemotePropertyChangeSupport<>();
    }

    @Override
    public void register(String firstName, String lastName, long dob, String address, String postalCode, String city, String phone, String email, String password, String cpr) throws RemoteException {
        try {

            var userResponse = SqlUserDao.getInstance().register(firstName, lastName, dob, address, postalCode, city, phone, email, password, cpr);
            if (userResponse != null) {
                this.support.firePropertyChange(ObserverEvents.USER_CREATED, null, userResponse);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void login(String email, String password) throws RemoteException {
        try {
            var userResponse = SqlUserDao.getInstance().getByEmailAndPassword(email, password);
            if (userResponse == null) {
                throw new RuntimeException("User not found");
            }

            this.support.firePropertyChange(ObserverEvents.USER_LOGGED_IN, null, userResponse);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void addPropertyChangeListener(
            RemotePropertyChangeListener<Serializable> listener) throws RemoteException {
        this.support.addPropertyChangeListener(listener);
    }
}
