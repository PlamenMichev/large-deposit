package dk.via.largedeposit.model.enums;

import java.util.Arrays;

public enum Currency {
    DKK,
    EUR,
    USD;

    public static Currency valueOf(int value) {
        return Arrays.stream(values())
                .filter(role -> role.ordinal() == value)
                .findFirst()
                .orElse(null);
    }
}
