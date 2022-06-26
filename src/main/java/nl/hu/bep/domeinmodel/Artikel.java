package nl.hu.bep.domeinmodel;

public class Artikel {
    String artikelnr;
    String naam;
    double prijs;
    String merk;
    String maat;
    String omschrijving;
    String kleur;
    String materiaal;

    public Artikel(String artikelnr,
                   String naam,
                   double prijs,
                   String merk,
                   String maat,
                   String omschrijving,
                   String kleur,
                   String materiaal){

        this.artikelnr = artikelnr;
        this.naam = naam;
        this.prijs = prijs;
        this.merk = merk;
        this.maat = maat;
        this.omschrijving = omschrijving;
        this.kleur = kleur;
        this.materiaal = materiaal;
    }

    private String getArtikelnr() {
        return artikelnr;
    }

    private void setArtikelnr(String artikelnr) {
        this.artikelnr = artikelnr;
    }

    private String getNaam() {
        return naam;
    }

    private void setNaam(String naam) {
        this.naam = naam;
    }

    private double getPrijs() {
        return prijs;
    }

    private void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    private String getMerk() {
        return merk;
    }

    private void setMerk(String merk) {
        this.merk = merk;
    }

    private String getMaat() {
        return maat;
    }

    private void setMaat(String maat) {
        this.maat = maat;
    }

    private String getOmschrijving() {
        return omschrijving;
    }

    private void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    private String getKleur() {
        return kleur;
    }

    private void setKleur(String kleur) {
        this.kleur = kleur;
    }

    private String getMateriaal() {
        return materiaal;
    }

    private void setMateriaal(String materiaal) {
        this.materiaal = materiaal;
    }
}
