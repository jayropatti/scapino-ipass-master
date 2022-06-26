package nl.hu.bep.domeinmodel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Medewerker {
    private static String naam;
    private String persnr;
    private String wachtwoord;
    private static List<Medewerker>alleMedewerkers = new ArrayList<>();

    public Medewerker(String naam, String persnr, String wachtwoord){
        this.naam = naam;
        this.persnr = persnr;
        this.wachtwoord = wachtwoord;

    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medewerker medewerker = (Medewerker) o;
        return naam.equals(medewerker.naam);

    }

    @Override
    public int hashCode(){
        return Objects.hash(naam);
    }

    public static String getNaam(){
        return naam;
    }

    public String getPersoneelsnummer(){
        return persnr;
    }

    public String getWachtwoord(){
        return wachtwoord;
    }

    public static List<Medewerker> getAlleMedewerkers(){
        return Collections.unmodifiableList(alleMedewerkers);
    }

    public String toString() {
        return "Medewerker:" + this.naam + ", heeft personeelsnummer:" + this.persnr + ", met wachtwoord:" + this.wachtwoord;
    }

    public boolean checkWachtwoord(){
        return true;
    }


}
