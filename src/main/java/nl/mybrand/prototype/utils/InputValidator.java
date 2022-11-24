package nl.mybrand.prototype.utils;

public final class InputValidator {

    private InputValidator() {
    }

    public static boolean inputIsSmallerThanSmallestValue(int input, int smallestValue) {
        return input < smallestValue;
    }

    public static boolean inputIsGreaterThanHighestValue(int input, int highestValue) {
        return input > highestValue;
    }

}
