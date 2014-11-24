package jeu.core.de;

import java.util.Observable;
import jeu.core.Randomizer;

public class De extends Observable{
    int valeurFace;
    int id;
    public De(int id){
        this.id = id;
    }
    
    public int lancer(){
        setValeur(Randomizer.getRandom());
        setChanged();
        notifyObservers(valeurFace);
        return valeurFace;
    }
    
    public void display(){
        
    }
    
    private void setValeur(int val){
        this.valeurFace = val;
    }
    
    public int getId(){
        return this.id;
    }
    
}
