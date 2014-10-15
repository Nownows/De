/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeude.controller;

import jeude.De;
import jeude.Joueur;
import jeude.ui.VueDe;
import jeude.ui.VueJoueur;

public class Gestion {

    private De de1;
    private De de2;
    private Joueur j;
    private VueJoueur vj;
    private VueDe vd1;
    private VueDe vd2;

    /**
     * Constructeur privé
     */
    private Gestion() {
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

    private static Gestion INSTANCE = null;

    public static synchronized Gestion getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Gestion();
        }
        return INSTANCE;
    }
    
    public void lancerLesDes(){
        de1.lancer();
        de2.lancer();          
    }
}
