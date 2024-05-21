package dk.via.largedeposit.model;

import java.beans.PropertyChangeListener;

public interface Model {
    void register(String firstName, String lastName, long dob, String address, String postalCode, String city, String phone, String email, String password, String cpr);
    void addPropertyChangeListener(PropertyChangeListener listener);
}