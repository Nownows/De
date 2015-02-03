package jeu.core.de;

public class DeSimultanes implements Strategie{

    @Override
    public int lancerLesDes(De d1, De d2) {
        int v1,v2;
        v1 = d1.lancer();
        v2 = d2.lancer();
        return v1+v2;
    } 
}
