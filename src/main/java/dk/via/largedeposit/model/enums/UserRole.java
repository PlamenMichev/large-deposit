package dk.via.largedeposit.model.enums;

import java.util.Arrays;
import java.util.Optional;
/**
 * Class used to define the allowed user roles
 */

public enum UserRole {
    /**
     * Admin
     */
    ADMIN,
    /**
     * Customer
     */
    CUSTOMER;

    /**
     * Method used to get the userRole of a user
     * @param value the desired user
     * @return the userRole of a user
     */
    public static UserRole valueOf(int value) {
        return Arrays.stream(values())
                .filter(role -> role.ordinal() == value)
                .findFirst()
                .orElse(null);
    }
}
