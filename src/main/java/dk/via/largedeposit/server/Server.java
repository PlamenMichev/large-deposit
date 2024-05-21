package dk.via.largedeposit.server;

import dk.via.largedeposit.model.User;
import dk.via.remote.observer.RemotePropertyChangeListener;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {
    User register(String firstName, String lastName, long dob, String address, String postalCode, String city, String phone, String email, String password, String cpr) throws RemoteException;
    void addPropertyChangeListener(RemotePropertyChangeListener<Serializable> listener) throws RemoteException;

}
