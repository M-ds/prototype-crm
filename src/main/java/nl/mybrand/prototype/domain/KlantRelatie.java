package nl.mybrand.prototype.domain;

public class KlantRelatie {
    private String bedrijfsnaam;
    private String contactPersoon;
    private String adres;
    private String postcode;
    private String email;
    private String telefoonnummer;
    private String notities;

    public KlantRelatie(String bedrijfsnaam, String contactPersoon, String adres, String postcode, String email, String telefoonnummer, String notities) {
        this.bedrijfsnaam = bedrijfsnaam;
        this.contactPersoon = contactPersoon;
        this.adres = adres;
        this.postcode = postcode;
        this.email = email;
        this.telefoonnummer = telefoonnummer;
        this.notities = notities;
    }

    public String getBedrijfsnaam() {
        return bedrijfsnaam;
    }

    public void setBedrijfsnaam(String bedrijfsnaam) {
        this.bedrijfsnaam = bedrijfsnaam;
    }

    public String getContactPersoon() {
        return contactPersoon;
    }

    public void setContactPersoon(String contactPersoon) {
        this.contactPersoon = contactPersoon;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public String getNotities() {
        return notities;
    }

    public void setNotities(String notities) {
        this.notities = notities;
    }
}