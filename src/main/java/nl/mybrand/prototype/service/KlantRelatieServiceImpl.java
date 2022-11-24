package nl.mybrand.prototype.service;

import nl.mybrand.prototype.domain.KlantRelatie;

import java.util.ArrayList;
import java.util.List;

public class KlantRelatieServiceImpl implements KlantRelatieService {

    private static final List<KlantRelatie> klantRelaties = new ArrayList<>();

    static {
        klantRelaties.add(new KlantRelatie("Mybrand", "Bob de Bouwer", "Vijverlaan 12", "1234 AB", "voorbeeld@mail.com", "06123456789", "Bla bla bla"));
        klantRelaties.add(new KlantRelatie("Bouwbedrijf", "Bobien de bouwer", "Genstestraat 123", "1234 CB", "voorbeeld-2@mail.com", "123476959", "Bla bla bla bla bla bla"));
        klantRelaties.add(new KlantRelatie("Bredrijg", "Contact Persoon", "Veerstraat 10", "9000 AB", "voorbeeld-3@mail.com", "12345677", "Notities en nog meer dingen"));
    }

    @Override
    public List<KlantRelatie> getAllKlantRelaties() {
        return klantRelaties;
    }
}
