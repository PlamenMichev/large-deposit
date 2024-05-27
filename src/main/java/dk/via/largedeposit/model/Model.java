package dk.via.largedeposit.model;

import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Model {
    User register(String firstName, String lastName, long dob, String address, String postalCode, String city, String phone, String email, String password, String cpr);
    User login(String email, String password);
    ArrayList<User> getUsers() throws RemoteException;
    User getCurrentUser();
    void toggleUserActiveStatus(int id);
    void addPropertyChangeListener(PropertyChangeListener listener);
}