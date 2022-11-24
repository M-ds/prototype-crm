package nl.mybrand.prototype.service;

import nl.mybrand.prototype.domain.ContactMoment;

import java.util.List;

public interface ContactMomentService {

    /**
     * Zoek alle contact momenten voor een klant
     *
     * @param klantId om te zoeken
     * @return lijst met alle contact momenten
     */
    List<ContactMoment> findContactMomentenVoorKlant(int klantId);
}
