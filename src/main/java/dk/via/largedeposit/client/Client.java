package dk.via.largedeposit.client;

import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;

public interface Client {
    void register(String firstName, String lastName, long dob, String address, String postalCode, String city, String phone, String email, String password, String cpr) throws RemoteException;
    void login(String email, String password) throws RemoteException;
    void addPropertyChangeListener(PropertyChangeListener listener);
}
