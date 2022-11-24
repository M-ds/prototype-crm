package nl.mybrand.prototype.ui;

import nl.mybrand.prototype.utils.InputValidator;

import java.util.Scanner;

public class MainMenu {

    private final Scanner scanner;
    private final KlantRelatiesUi klantRelatiesUi;

    public MainMenu(Scanner scanner) {
        this.scanner = scanner;
        this.klantRelatiesUi = new KlantRelatiesUi(scanner);
    }

    public boolean mainMenuChoices() {
        boolean applicationLoop = true;
        System.out.println("Je kan de volgende opties kiezen: [1] Toon klantrelaties, [2] stop.");

        while (!scanner.hasNextInt()) {
            System.out.println("input is not numeric, please choose a valid number");
            scanner.next();
        }

        int userInput = scanner.nextInt();

        if (!isInputValid(userInput)) {
            mainMenuChoices();
        }

        switch (userInput) {
            case 1:
                System.out.println("Toon alle klantenrelaties");
                klantRelatiesUi.showKlantRelatieUi();
                break;
            case 2:
                System.out.println("Applicatie wordt afgesloten");
                applicationLoop = false;
                break;
            default:
                System.out.println("Niet bekende keuze, controleer je input");
                break;
        }

        return applicationLoop;
    }

    private boolean isInputValid(int input) {
        if (InputValidator.inputIsSmallerThanSmallestValue(input, 1)) {
            System.out.println("Input is kleiner dan de laagst mogelijke input, controleer je input.");
            return false;
        }

        if (InputValidator.inputIsGreaterThanHighestValue(input, 2)) {
            System.out.println("Input is groter dan de hoogst mogelijke input, controleer je input.");
            return false;
        }
        return true;
    }
}
