/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.core;

import java.util.Observable;
import java.util.Random;
import jeu.persist.Joueur;
import jeu.persist.factory.JdbcKit;
import jeu.persist.factory.PersistKit;
import jeu.persist.factory.SrKit;
import jeu.persist.factory.XmlKit;
import jeu.persist.scores.HighScore;
import jeu.ui.MenuForm;
import jeu.ui.VueDe;
import jeu.ui.VueJoueur;
import jeu.ui.VuePartie;

public class Partie extends Observable {

    private final int NB_MANCHES = 3;
    private final int NB_TOURS = 10;
    private int nbTours = 10;
    private De de1, de2;
    private Joueur j;
    private VueJoueur vj;
    private VueDe vd1, vd2;
    private VuePartie vp;

    /**
     * Constructeur privé
     */
    public Partie(String nomJoueur) {
        de1 = new De(1);
        de2 = new De(2);
        j = new Joueur(nomJoueur, 0);
        vj = new VueJoueur();
        j.addObserver(vj);
        vd1 = new VueDe();
        de1.addObserver(vd1);
        vd2 = new VueDe();
        de2.addObserver(vd2);
        vp = new VuePartie();
        this.addObserver(vp);
    }

    public void lancerLesDes() {
        if (nbTours == 0) {
            return;
        }
        int v1 = de1.lancer();
        int v2 = de2.lancer();
        if (v1 + v2 == 10) {
            marquerPoints(10);
        }
        nbTours--;
        setChanged();
        notifyObservers(nbTours);
    }

    public Integer getNbTours() {
        return nbTours;
    }

    public void marquerPoints(int score) {
        j.addScore(score);
    }
    
    public Joueur getJoueur(){
        return this.j;
    }

    /*
     Fonction tres utile de sauvegarde via un moyen aléatoire
     ce qui fait qu'on ne pourra pas lister les scores.
     */
    public void sauvegarder() {
        PersistKit pk;
        HighScore highscore;

        Random r = new Random();
        int alea = r.nextInt(300);
        if (alea <= 100) {
            pk = new JdbcKit();
        } else if (alea > 100 && alea <= 200) {
            pk = new SrKit();
        } else {
            pk = new XmlKit();
        }
        highscore = pk.makeKit();
        highscore.ecrire();

    }

    public static void main(String[] args) {
        MenuForm mf = new MenuForm();
        mf.setLocationRelativeTo(null);
        mf.setVisible(true);
    }
}
