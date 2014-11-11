/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.ui;

import java.util.Observable;
import java.util.Observer;
import jeu.core.Partie;


public class VuePartie implements Observer {
    LancerForm2 lf;

    public VuePartie() {
        lf = LancerForm2.getForm();
    }
    
    
    @Override
    public void update(Observable o, Object arg) {
        lf.setNbLancer((Integer)arg);
        Partie j = (Partie)o;
        lf.setJoueurActif(j.getJoueurActif().getNom());
    }

}
