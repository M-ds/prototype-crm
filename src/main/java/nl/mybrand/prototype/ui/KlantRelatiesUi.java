package nl.mybrand.prototype.ui;

import nl.mybrand.prototype.domain.KlantRelatie;
import nl.mybrand.prototype.service.KlantRelatieService;
import nl.mybrand.prototype.service.KlantRelatieServiceImpl;
import nl.mybrand.prototype.utils.InputValidator;

import java.util.Scanner;

public class KlantRelatiesUi {

    private final Scanner scanner;
    private final KlantRelatieService klantRelatieService;

    public KlantRelatiesUi(Scanner scanner) {
        this.scanner = scanner;
        this.klantRelatieService = new KlantRelatieServiceImpl();
    }

    public void showKlantRelatieUi() {
        System.out.println("Je kan de volgende opties kiezen: [1] toon alle relaties, [2] ga terug naar applicatie.");

        while (!scanner.hasNextInt()) {
            System.out.println("input is not numeric, please choose a valid number");
            scanner.next();
        }

        int userInput = scanner.nextInt();

        if (!isInputValid(userInput)) {
            showKlantRelatieUi();
        }

        switch (userInput) {
            case 1:
                System.out.println("Alle bekende klantgegevens:");
                final var klantRelaties = klantRelatieService.getAllKlantRelaties();
                for (KlantRelatie klantRelatie : klantRelaties) {
                    System.out.println(formatKlantRelatie(klantRelatie));
                    System.out.println();
                }
                break;
            case 2:
                System.out.println("Toevoegen van een nieuwe klant");
                break;
            case 3:
                System.out.println("Ga terug");
                break;
        }
    }

    private String formatKlantRelatie(KlantRelatie klantRelatie) {
        return "Bedrijf: %s%nContact persoon: %s%nAdres: %s %s%nEmail: %s%nTelefoonnummer: %s%nNotities: %s".formatted(
                klantRelatie.getBedrijfsnaam(),
                klantRelatie.getContactPersoon(),
                klantRelatie.getAdres(),
                klantRelatie.getPostcode(),
                klantRelatie.getEmail(),
                klantRelatie.getTelefoonnummer(),
                klantRelatie.getNotities()
        );
    }


    private boolean isInputValid(int input) {
        if (InputValidator.inputIsSmallerThanSmallestValue(input, 1)) {
            System.out.println("Input is smaller than the lower possible value. Please check input");
            return false;
        }

        if (InputValidator.inputIsGreaterThanHighestValue(input, 2)) {
            System.out.println("Input is too big, please check your input.");
            return false;
        }
        return true;
    }
}
