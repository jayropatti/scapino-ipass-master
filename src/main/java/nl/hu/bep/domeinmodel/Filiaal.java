package nl.hu.bep.domeinmodel;

import java.io.Serializable;

public class Filiaal implements Serializable {
    private String naam;
    private String filiaalnummer;
    private String adres;
    private String postcode;

    public Filiaal(String naam, String filiaalnummer, String adres, String postcode) {
        this.naam = naam;
        this.filiaalnummer = filiaalnummer;
        this.adres = adres;
        this.postcode = postcode;


    }



//    private static Filiaal mijn_filiaal = new Filiaal();
//
//    public static void setFiliaal(Filiaal filiaal) {
//        mijn_filiaal = filiaal;
//    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getFiliaalnummer() {
        return filiaalnummer;
    }

    public void setFiliaalnummer(String filiaalnummer) {
        this.filiaalnummer = filiaalnummer;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPostcode(){
        return postcode;
    }

    public void setPostcode(){
        this.postcode = postcode;
    }
}
