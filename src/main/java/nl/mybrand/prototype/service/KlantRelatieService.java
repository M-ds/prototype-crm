package nl.mybrand.prototype.service;

import nl.mybrand.prototype.domain.KlantRelatie;

import java.util.List;

public interface KlantRelatieService {

    /**
     * Geef alle bekende klantrelaties terug.
     * @return alle klant relaties
     */
    List<KlantRelatie> getAllKlantRelaties();

    /**
     * Voeg een klant relatie toe aan de bestaande lijst
     * @return true als het gelukt is
     */
    boolean toevoegenVanKlantrelatie();
}
