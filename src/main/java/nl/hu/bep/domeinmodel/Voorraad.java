package nl.hu.bep.domeinmodel;


public class Voorraad {
    Artikel artikel;
    Filiaal filiaal;

    public Voorraad(Filiaal filiaal, Artikel artikel){
        this.filiaal = filiaal;
        this.artikel = artikel;
    }

    private Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    public Filiaal getFiliaal() {
        return filiaal;
    }

    public void setFiliaal(Filiaal filiaal) {
        this.filiaal = filiaal;
    }

    public int aantalStuks(){
        //TODO:
//        Kijk hoeveel keer product1 in filiaal LR is:
//        for (product, waar productnaam/artikelnr zelfde is als zoekopdracht){
//            aantal stuks / voorraad + 1;
//        }
//
//
//        Filiaal LR: stuks = 2
//        Filiaal UT: Stuks = 3
//        Filiaal WOE: Stuks = 1
        return 0;
    }

    public boolean opVoorraad(){
        //TODO:
        /*als product op voorraad is in filiaal, opVoorraad() == True.*/
        return false;
    }
}
