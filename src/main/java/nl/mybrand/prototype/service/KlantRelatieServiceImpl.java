package nl.mybrand.prototype.service;

import nl.mybrand.prototype.domain.KlantRelatie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KlantRelatieServiceImpl implements KlantRelatieService {

    private final List<KlantRelatie> klantRelaties = new ArrayList<>();
    private final Scanner scanner;

    public KlantRelatieServiceImpl(Scanner scanner) {
        this.scanner = scanner;
        // Dit zorgt ervoor dat we spaties kunnen gebruiker voor een nieuwe relatie toe te voegen.
        this.scanner.useDelimiter("\n");

        klantRelaties.add(new KlantRelatie(1, "Mybrand", "Bob de Bouwer", "Vijverlaan 12", "1234 AB", "voorbeeld@mail.com", "06123456789", "Bla bla bla"));
        klantRelaties.add(new KlantRelatie(2, "Bouwbedrijf", "Bobien de bouwer", "Genstestraat 123", "1234 CB", "voorbeeld-2@mail.com", "123476959", "Bla bla bla bla bla bla"));
        klantRelaties.add(new KlantRelatie(3, "Bredrijg", "Contact Persoon", "Veerstraat 10", "9000 AB", "voorbeeld-3@mail.com", "12345677", "Notities en nog meer dingen"));
    }

    @Override
    public List<KlantRelatie> getAllKlantRelaties() {
        return klantRelaties;
    }

    @Override
    public boolean toevoegenVanKlantrelatie() {
        KlantRelatie nieuweKlantRelatie = new KlantRelatie();
        bedrijfNaamInput(nieuweKlantRelatie);

        if (nieuweKlantRelatie.getBedrijfsnaam() == null || nieuweKlantRelatie.getBedrijfsnaam().isBlank()) {
            return false;
        }

        contactPersoonInput(nieuweKlantRelatie);
        adresInput(nieuweKlantRelatie);
        postcodeInput(nieuweKlantRelatie);
        emailInput(nieuweKlantRelatie);
        telefoonInput(nieuweKlantRelatie);
        notitiesInput(nieuweKlantRelatie);
        nieuweKlantRelatie.setId(getNextId());

        klantRelaties.add(nieuweKlantRelatie);
        return true;
    }

    private void bedrijfNaamInput(KlantRelatie nieuweKlantRelatie) {
        System.out.println("Naam van het bedrijf: ");
        String naam = scanner.next();
        nieuweKlantRelatie.setBedrijfsnaam(naam);
    }

    private void contactPersoonInput(KlantRelatie nieuweKlantRelatie) {
        System.out.println("Naam van de contact persoon: ");
        String contactPersoon = scanner.next();
        nieuweKlantRelatie.setContactPersoon(contactPersoon);
    }

    private void adresInput(KlantRelatie nieuweKlantRelatie) {
        System.out.println("Adres van het bedrijf: ");
        String adres = scanner.next();
        nieuweKlantRelatie.setAdres(adres);
    }

    private void postcodeInput(KlantRelatie nieuweKlantRelatie) {
        System.out.println("Postcode van het bedrijf: ");
        String postcode = scanner.next();
        nieuweKlantRelatie.setPostcode(postcode);
    }

    private void emailInput(KlantRelatie nieuweKlantRelatie) {
        System.out.println("Email van het bedrijf: ");
        String email = scanner.next();
        nieuweKlantRelatie.setEmail(email);
    }

    private void telefoonInput(KlantRelatie nieuweKlantRelatie) {
        System.out.println("Telefoonnummer van het bedrijf: ");
        String telefoonnummer = scanner.next();
        nieuweKlantRelatie.setTelefoonnummer(telefoonnummer);
    }

    private void notitiesInput(KlantRelatie nieuweKlantRelatie) {
        System.out.println("Noties voor de klantrelaties: ");
        String notities = scanner.next();
        nieuweKlantRelatie.setNotities(notities);
    }

    private int getNextId() {
        return klantRelaties.size() + 1;
    }
}
