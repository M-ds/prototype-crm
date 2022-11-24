package nl.mybrand.prototype.utils;

public final class InputValidator {

    private static final String NUMMERIC_REGEX = "^[0-9]*$";

    private InputValidator() {
    }

    public static boolean isNumeric(String input) {
        // would return null if the input does not match the regular expression.
        if(input.matches(NUMMERIC_REGEX)) {
            return true;
        }
        return false;
    }

    public static boolean inputIsSmallerThanSmallestValue(String input, int smallestValue) {
        if(input == null || input.equals("")) {
            return true;
        }
        return Integer.parseInt(input) < smallestValue;
    }

    public static boolean inputIsGreaterThanHighestValue(String input, int highestValue) {
        if(input == null || input.equals("")) {
            return true;
        }
        return Integer.parseInt(input) > highestValue;
    }

    public static boolean isAlpabetic(String input) {
        return input.chars().allMatch(Character::isLetter);
    }

}
