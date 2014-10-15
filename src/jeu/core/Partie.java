/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.core;

import jeu.persist.Joueur;
import jeu.ui.LancerForm;
import jeu.ui.MenuForm;
import jeu.ui.VueDe;
import jeu.ui.VueJoueur;

public class Partie {

    private int nbTours = 10;
    private De de1;
    private De de2;
    private Joueur j;
    private VueJoueur vj;
    private VueDe vd1;
    private VueDe vd2;

    /**
     * Constructeur privé
     */
    private Partie() {
        de1 = new De(1);
        de2 = new De(2);
        j = new Joueur("toto",0);               
        vj = new VueJoueur();
        j.addObserver(vj);
        vd1 = new VueDe();
        de1.addObserver(vd1);
        vd2 = new VueDe();
        de2.addObserver(vd2);
    }

    private static Partie INSTANCE = null;

    public static synchronized Partie getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Partie();
        }
        return INSTANCE;
    }
    
    public int lancerLesDes(){
        if (nbTours == 0) {
            return -1;
        }
        de1.lancer();
        de2.lancer();    
        nbTours--;
        return 0;
    }
    
    public Integer getNbTours(){
        return nbTours;
    }
    
    public static void main(String[] args) {
        MenuForm mf = new MenuForm();
        mf.setLocationRelativeTo(null);
        mf.setVisible(true);
    }
}
