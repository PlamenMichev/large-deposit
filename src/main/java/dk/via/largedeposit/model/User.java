package dk.via.largedeposit.model;

import dk.via.largedeposit.model.enums.UserRole;

public class User {
    private int id;
    private String cprNumber;
    private String firstName;
    private String lastName;
    private UserRole role;
    private String address;
    private String postalCode;
    private String city;
    private String phoneNumber;
    private String email;
    private String password;
    private boolean isVerified;
    private final long dateOfBirth;
    private final long createdAt;

    // Admin constructor
    public User(
            String cprNumber,
            String firstName,
            String lastName,
            UserRole role,
            String address,
            String postalCode,
            String city,
            String phoneNumber,
            String email,
            String password,
            boolean isVerified,
            long dateOfBirth,
            long createdAt) {
        id = -1;
        this.cprNumber = cprNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.isVerified = isVerified;
        this.dateOfBirth = dateOfBirth;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public String getCprNumber() {
        return cprNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public long getDateOfBirth() {
        return dateOfBirth;
    }

    public long getCreatedAt() {
        return createdAt;
    }
}
