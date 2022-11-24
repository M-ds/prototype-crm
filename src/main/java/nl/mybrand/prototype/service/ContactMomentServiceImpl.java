package nl.mybrand.prototype.service;

import nl.mybrand.prototype.domain.ContactMoment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class ContactMomentServiceImpl implements ContactMomentService {

    private final List<ContactMoment> alleContactMomenten = new ArrayList<>();

    public ContactMomentServiceImpl() {
        // Test data;
        alleContactMomenten.add(new ContactMoment(LocalDate.of(2021, Month.JULY, 2), LocalTime.of(10, 30, 0), "Raamsdonkveer 1000 AB", 1, "Dit zijn een paar notities die toegevoegd zijn"));
        alleContactMomenten.add(new ContactMoment(LocalDate.of(2021, Month.AUGUST, 5), LocalTime.of(16, 30, 0), "Oosterhout 1356 AB", 1, "Test"));
        alleContactMomenten.add(new ContactMoment(LocalDate.of(2022, Month.OCTOBER, 7), LocalTime.of(9, 30, 0), "Breda 1690 AB", 2, "random"));
        alleContactMomenten.add(new ContactMoment(LocalDate.of(2021, Month.JANUARY, 12), LocalTime.of(10, 30, 0), "Utracht 1058 AB", 3, "Dit zijn een paar notities die toegevoegd zijn, Dit zijn een paar notities die toegevoegd zijn"));
        alleContactMomenten.add(new ContactMoment(LocalDate.of(2021, Month.JULY, 22), LocalTime.of(13, 30, 0), "Rotterdam 1000 GH", 3, "Dit"));
        alleContactMomenten.add(new ContactMoment(LocalDate.of(2021, Month.FEBRUARY, 23), LocalTime.of(10, 30, 0), "Zaamslag 1000 AB", 1, "voorbeeld"));
        alleContactMomenten.add(new ContactMoment(LocalDate.of(2021, Month.JULY, 21), LocalTime.of(10, 30, 0), "Amsterdam 1000 AB", 2, "Text die toegevoegd is."));
    }

    @Override
    public List<ContactMoment> findContactMomentenVoorKlant(int klantId) {
        return alleContactMomenten.stream().filter(contactMoment -> contactMoment.getKlantId() == klantId).toList();
    }

}
