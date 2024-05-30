package dk.via.largedeposit.client;

import dk.via.largedeposit.model.Account;
import dk.via.largedeposit.model.User;

import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface Client {
    User register(String firstName, String lastName, long dob, String address, String postalCode, String city, String phone, String email, String password, String cpr) throws RemoteException;
    User login(String email, String password) throws RemoteException;
    ArrayList<User> getUsers() throws RemoteException;
    void toggleUserActiveStatus(int id) throws RemoteException;
    ArrayList<Account> getAccounts() throws RemoteException;
    Account createAccount(String type, String name, String currency, User user) throws RemoteException;
    void addPropertyChangeListener(PropertyChangeListener listener);
}
