package dk.via.largedeposit.model.enums;

import java.util.Arrays;

/**
 * Class used to define the allowed currencies
 */
public enum Currency {
    /**
     * Danish crowns
     */
    DKK,
    /**
     * Euros
     */
    EUR,
    /**
     * Dollars
     */
    USD;

    /**
     * Method used to get the Currency of an account
     * @param value the desired account
     * @return the Currency of an account
     */
    public static Currency valueOf(int value) {
        return Arrays.stream(values())
                .filter(role -> role.ordinal() == value)
                .findFirst()
                .orElse(null);
    }
}
