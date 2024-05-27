package dk.via.largedeposit.model;

import dk.via.largedeposit.model.enums.UserRole;

import java.io.Serializable;

/**
 * Class used to store and manipulate the information about a user
 */
public class User implements Serializable {
    /**
     * The id of the user
     */
    private int id;
    /**
     * The cpr of the user
     */
    private String cprNumber;
    /**
     * The first name of the user
     */
    private String firstName;
    /**
     * The last name of the user
     */
    private String lastName;
    /**
     * The role of the user
     */
    private UserRole role;
    /**
     * The address of the user
     */
    private String address;
    /**
     * The postal code of the user
     */
    private String postalCode;
    /**
     * The city of the user
     */
    private String city;
    /**
     * The phone number of the user
     */
    private String phoneNumber;
    /**
     * The email of the user
     */
    private String email;
    /**
     * The password of the user
     */
    private String password;
    /**
     * The verification status of the user
     */
    private boolean isVerified;
    /**
     * The date of birth of the user
     */
    private final long dateOfBirth;
    /**
     * The creation time of the user profile
     */
    private final long createdAt;

    /**
     * Constructor
     * @param cprNumber The cpr of the user
     * @param firstName The first name of the user
     * @param lastName The last name of the user
     * @param role The role of the user
     * @param address The address of the user
     * @param postalCode The postal code of the user
     * @param city The city of the user
     * @param phoneNumber The phone number of the user
     * @param email The email of the user
     * @param password The password of the user
     * @param isVerified The verification status of the user
     * @param dateOfBirth The date of birth of the user
     * @param createdAt The creation time of the user profile
     */
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

    /**
     * Getter
     * @return the id of the user
     */
    public int getId() {
        return id;
    }

    /**
     * Getter
     * @return the cpr of the user
     */
    public String getCprNumber() {
        return cprNumber;
    }

    /**
     * Getter
     * @return the first name of the user
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter
     * @param firstName the first name of the user
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter
     * @return the last name of the user
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter
     * @param lastName the last name of the user
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter
     * @return the role of the user
     */
    public UserRole getRole() {
        return role;
    }

    /**
     * Setter
     * @param role the role of the user
     */
    public void setRole(UserRole role) {
        this.role = role;
    }

    /**
     * Getter
     * @return the address of the user
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter
     * @param address the address of the user
     */

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter
     * @return the postal code of the user
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Setter
     * @param postalCode the postal code of the user
     */

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Getter
     * @return the city of the user
     */
    public String getCity() {
        return city;
    }

    /**
     * Setter
     * @param city the city of the user
     */

    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Getter
     * @return the phone number of the user
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Setter
     * @param phoneNumber the phone number of the user
     */

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter
     * @return the email of the user
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter
     * @param email the email of the user
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter
     * @param password the password of the user
     */

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter
     * @return the verification status of the user
     */
    public boolean getIsVerified() {
        return isVerified;
    }

    /**
     * Setter
     * @param isVerified the verification status of the user
     */

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    /**
     * Getter
     * @return the date of birth of the user
     */
    public long getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Getter
     * @return the creation time of the user profile
     */
    public long getCreatedAt() {
        return createdAt;
    }
}
