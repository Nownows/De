/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.core.de;

import java.util.Observable;
import jeu.ui.VueDe;


public class Des{
    De d1,d2;
    Strategie st;
    private int totalScoreDes;

    public Des() {
        d1 = new De(1);
        d2 = new De(2);
        d1.addObserver(new VueDe());
        d2.addObserver(new VueDe());
    }   

    public void setSt(Strategie st) {
        this.st = st;
    }
      
    public int lancerDes(){ 
        return (st.lancerLesDes(d1, d2));
    }
}
