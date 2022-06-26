package nl.hu.bep.domeinmodel;

import java.util.ArrayList;
import java.util.List;

public class Rayon{
//    String naam;
//    List<Filiaal> filialen = new ArrayList<>();
//
//    public Rayon(String naam){
//        this.naam = naam;
//    }
//
//    public void filiaalNamen(){
//
//        for (int i = 0; i < filialen.size();i++)
//        {
//            System.out.println(filialen.get(i));
//        }
//
//    }
//
//    public String toString(){
//        int size = filialen.size();
//        String message = "Aantal filialen in rayon: " + size;
//        System.out.println(message);
//        return message;
//    }

//    --------- conf filialen  ----------------

    private List<Filiaal> filialen = new ArrayList<>();
    private List<Medewerker> medewerkers = new ArrayList<Medewerker>();


    private static Rayon mijn_rayon = new Rayon();
    public static Rayon getRayon() {
        return mijn_rayon;
    }

    public static void setRayon(Rayon rayon) {
        mijn_rayon = rayon;
    }

    private Rayon(){
        filialen.add(new Filiaal("Scapino Leidsche Rijn", "1", "Luxemburgpromenade 134", "3541DC"));
        filialen.add(new Filiaal("Scapino Utrecht", "2", "Oude Gracht 83", "3511AD"));
        filialen.add(new Filiaal("Scapino Woerden", "3", "Achterstraat 24", "3441EH"));
        filialen.add(new Filiaal("Scapino Mijdrecht", "4", "Passage 24 a", "3641AK"));
        filialen.add(new Filiaal("Scapino Hilversum", "5", "Noordse Bosje 7", "1211BD"));
        filialen.add(new Filiaal("Scapino Soest", "6", "Soesterbergsestraat 51 b", "3768EB"));
        filialen.add(new Filiaal("Scapino Utrecht", "7", "Kamp 36", "3811AS"));
        filialen.add(new Filiaal("Scapino De Bilt", "8", "Hessenweg 133 a", "3731JG"));
        filialen.add(new Filiaal("Scapino Zeist", "9", "Voorheuvel 37 -39", "3701JB"));

    }

    public List<Filiaal> getFilialen() {
        return filialen;
    }

    public Filiaal getFiliaalCode(String code){
        for (Filiaal filiaal : filialen){
            if (filiaal.getFiliaalnummer().equals(code)){
                return filiaal;
            }
        }
        return null;

    }

    public boolean addFiliaal(Filiaal newFilliaal){
        if (getFiliaalCode(newFilliaal.getFiliaalnummer()) == null){
            return filialen.add(newFilliaal);
        }
        return false;
    }




}

