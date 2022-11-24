package nl.mybrand.prototype.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class ContactMoment {
    private LocalDate datum;
    private LocalTime tijd;
    private String locatie;
    private int klantId;
    private String notities;

    public ContactMoment(LocalDate datum, LocalTime tijd, String locatie, int klantId, String notities) {
        this.datum = datum;
        this.tijd = tijd;
        this.locatie = locatie;
        this.klantId = klantId;
        this.notities = notities;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public String formattedDatum() {
        return datum.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public LocalTime getTijd() {
        return tijd;
    }

    public String formattedTime() {
        return DateTimeFormatter.ISO_TIME.format(tijd);
    }

    public void setTijd(LocalTime tijd) {
        this.tijd = tijd;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public int getKlantId() {
        return klantId;
    }

    public void setKlantId(int klantId) {
        this.klantId = klantId;
    }

    public String getNotities() {
        return notities;
    }

    public void setNotities(String notities) {
        this.notities = notities;
    }
}
