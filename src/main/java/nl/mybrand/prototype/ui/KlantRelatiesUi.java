package nl.mybrand.prototype.ui;

import nl.mybrand.prototype.domain.ContactMoment;
import nl.mybrand.prototype.domain.KlantRelatie;
import nl.mybrand.prototype.service.ContactMomentService;
import nl.mybrand.prototype.service.ContactMomentServiceImpl;
import nl.mybrand.prototype.service.KlantRelatieService;
import nl.mybrand.prototype.service.KlantRelatieServiceImpl;
import nl.mybrand.prototype.utils.InputValidator;

import java.util.List;
import java.util.Scanner;

public class KlantRelatiesUi {

    private final Scanner scanner;
    private final KlantRelatieService klantRelatieService;

    public KlantRelatiesUi(Scanner scanner) {
        this.scanner = scanner;
        ContactMomentService contactMomentService = new ContactMomentServiceImpl();
        this.klantRelatieService = new KlantRelatieServiceImpl(scanner, contactMomentService);
    }

    public void showKlantRelatieUi() {
        System.out.println("Je kan de volgende opties kiezen: [1] toon alle relaties, [2] toevoegen van een nieuwe klant, [3] ga terug naar main menu");

        while (!scanner.hasNextInt()) {
            System.out.println("Input is niet nummerriek, controleer je input.");
            scanner.next();
        }

        int userInput = scanner.nextInt();

        if (!isInputValid(userInput)) {
            showKlantRelatieUi();
        }

        switch (userInput) {
            case 1:
                System.out.println("Alle bekende klantgegevens:");
                List<KlantRelatie> klantRelaties = klantRelatieService.getAllKlantRelaties();
                for (KlantRelatie klantRelatie : klantRelaties) {
                    System.out.println(formatKlantRelatie(klantRelatie));
                }
                break;
            case 2:
                System.out.println("Toevoegen van een nieuwe klant");
                boolean success = klantRelatieService.toevoegenVanKlantrelatie();
                if (success) {
                    System.out.println("Klantrelatie is toegevoegd");
                } else {
                    System.out.println("Klantrelatie is niet toegevoegd, bedrijfnaam moet ingevuld zijn.");
                }
                break;
            case 3:
                System.out.println("Ga terug naar main menu");
                break;
        }
    }

    private String formatKlantRelatie(KlantRelatie klantRelatie) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-----------------------------");

        String formattedKlantRelatieGegevens = getFormattedKlantRelatieGegevens(klantRelatie);

        stringBuilder.append("\n");
        stringBuilder.append(formattedKlantRelatieGegevens);

        stringBuilder.append("\n");
        for (ContactMoment contactMoment : klantRelatie.getContactMomenten()) {
            stringBuilder.append("\n");
            stringBuilder.append(formatContactMoment(contactMoment));
        }

        return stringBuilder.toString();
    }

    private static String getFormattedKlantRelatieGegevens(KlantRelatie klantRelatie) {
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

    private String formatContactMoment(ContactMoment contactMoment) {
        return "Contact moment %n - datum: %s%n - tijd: %s%n - locatie: %s%n - notities: %s%n".formatted(
                contactMoment.formattedDatum(),
                contactMoment.formattedTime(),
                contactMoment.getLocatie(),
                contactMoment.getNotities()
        );
    }


    private boolean isInputValid(int input) {
        if (InputValidator.inputIsSmallerThanSmallestValue(input, 1)) {
            System.out.println("Input is lager dan verwacht, controleer je input.");
            return false;
        }

        if (InputValidator.inputIsGreaterThanHighestValue(input, 3)) {
            System.out.println("Input is te groot, controleer je input.");
            return false;
        }
        return true;
    }
}
