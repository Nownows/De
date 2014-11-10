/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.core;

import jeu.persist.Joueur;
import jeu.ui.LancerForm2;
import jeu.ui.MenuForm;
import jeu.ui.VueDe;
import jeu.ui.VueJoueur;

public class Partie {

    private int nbTours = 10;
    private De de1;
    private De de2;
    private Joueur j1;
    private Joueur j2;
    private VueJoueur vj1;
    private VueJoueur vj2;
    private VueDe vd1;
    private VueDe vd2;
    private Joueur joueurActif;

    /**
     * Constructeur privé
     */
    private Partie() {
        de1 = new De(1);
        de2 = new De(2);
        j1 = new Joueur("toto",0);     
        j2 = new Joueur("titi",0);     
        
        vj1 = new VueJoueur();
        vj2 = new VueJoueur();
        j1.addObserver(vj1);
        j2.addObserver(vj2);
        vd1 = new VueDe();
        de1.addObserver(vd1);
        vd2 = new VueDe();
        de2.addObserver(vd2);
        this.joueurActif = j1;
    }

    private static Partie INSTANCE = null;

    public static synchronized Partie getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Partie();
        }
        return INSTANCE;
    }
    
    public void lancerLesDes(){
        if (nbTours == 0) {
            return;
        }
        de1.lancer();
        de2.lancer();    
        nbTours--;
    }
    
    public Integer getNbTours(){
        return nbTours;
    }
    
    public Joueur getJoueurActif(){
        return this.joueurActif;
    }
    
    public void marquerPoints(int score){
        joueurActif.addScore(score);
    }
    
    public void changerJoueurActif(){
        if (joueurActif.equals(j1)){
            joueurActif = j2;
        }
        else {
            joueurActif = j1;
        }
    }
    
    public static void main(String[] args) {
        MenuForm mf = new MenuForm();
        mf.setLocationRelativeTo(null);
        mf.setVisible(true);
    }
}
