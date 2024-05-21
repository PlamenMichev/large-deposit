package dk.via.largedeposit.model.enums;

import java.util.Arrays;
import java.util.Optional;

public enum UserRole {
    ADMIN,
    CUSTOMER;

    public static UserRole valueOf(int value) {
        return Arrays.stream(values())
                .filter(role -> role.ordinal() == value)
                .findFirst()
                .orElse(null);
    }
}
