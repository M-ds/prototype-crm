package nl.mybrand.prototype.utils;

public final class InputValidator {

    private InputValidator() {
    }

    public static boolean inputIsKleinerDanLaagsteWaarde(int input, int laagsteWaarde) {
        return input < laagsteWaarde;
    }

    public static boolean inputIsGroterDanHoogsteWaarde(int input, int hoogsteWaarde) {
        return input > hoogsteWaarde;
    }

}
