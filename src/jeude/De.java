/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeude;

import java.util.Observable;

/**
 *
 * @author ASUS
 */
public class De extends Observable{
    int valeurFace;
    int id;
    public De(int id){
        this.id = id;
    }
    
    public void lancer(){
        setValeur(Randomizer.getRandom());
        setChanged();
        notifyObservers(valeurFace);
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
