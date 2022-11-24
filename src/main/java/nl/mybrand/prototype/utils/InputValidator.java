package nl.mybrand.prototype.utils;

public final class InputValidator {

    private static final String NUMMERIC_REGEX = "^[0-9]*$";

    private InputValidator() {
    }

    public static boolean inputIsSmallerThanSmallestValue(int input, int smallestValue) {
        return input < smallestValue;
    }

    public static boolean inputIsGreaterThanHighestValue(int input, int highestValue) {
      return input > highestValue;
    }

    public static boolean isAlpabetic(String input) {
        return input.chars().allMatch(Character::isLetter);
    }

}
