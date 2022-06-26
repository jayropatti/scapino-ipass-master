package nl.hu.bep;

import nl.hu.bep.domeinmodel.*;
import org.junit.jupiter.api.BeforeEach;


public class TestFiliaal {
    Artikel artikelGegevens;
    Rayon rayon;
    Filiaal filiaalGegevens;
    Medewerker medewerkers;
    Voorraad voorraad;

    public TestFiliaal() {
    }

    @BeforeEach
    public void initialize() {
        try{
            this.artikelGegevens = new Artikel("1014860221360", "Dames instappers", 29.99, "Hush puppies", "37", "Zwarte zomer dames instappers van Hush puppies", "Zwart", "Textiel");
            this.filiaalGegevens = new Filiaal("Scapino Leidsche Rijn", "1", "Luxemburgpromenade 134", "3541DC");
//            this.rayon = new Rayon("Midden");
            this.medewerkers = new Medewerker("Pieter Visser", "608239", "Kraanwater01");
            this.voorraad = new Voorraad(this.filiaalGegevens,this.artikelGegevens );
        } catch (Exception var3) {
            String errorMessage = "Exception: " + var3.getMessage();
            System.out.println(errorMessage);
        }
    }

}