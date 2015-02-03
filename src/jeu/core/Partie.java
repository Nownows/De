/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.core;

import jeu.core.de.De;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;
import jeu.core.de.DeDeuxPuisUn;
import jeu.core.de.DeSimultanes;
import jeu.core.de.DeUnPuisDeux;
import jeu.core.de.Des;
import jeu.core.de.Strategie;
import jeu.persist.Joueur;
import jeu.persist.Score;
import jeu.persist.Scores;
import jeu.persist.factory.JdbcKit;
import jeu.persist.factory.PersistKit;
import jeu.persist.factory.SrKit;
import jeu.persist.factory.XmlKit;
import jeu.persist.scores.HighScore;
import jeu.ui.MenuForm;
import jeu.ui.VueJoueur;
import jeu.ui.VuePartie;

public class Partie extends Observable {

    private int nbTours = 10;
    private Des des;
    private Joueur j;
    private VueJoueur vj;
    private VuePartie vp;

    public Partie(String nomJoueur) {
        des = new Des();
        des.setSt(randomStrategie());
        j = new Joueur(nomJoueur, 0);
        vj = new VueJoueur();
        j.addObserver(vj);
        vp = new VuePartie();
        this.addObserver(vp);
    }

    public void lancerLesDes() {
        if (nbTours == 0) {
            return;
        }

        int score = des.lancerDes();
        if (score == 10){
            marquerPoints(score);
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

    public Joueur getJoueur() {
        return this.j;
    }

    /*
     Fonction tres utile de sauvegarde via un moyen aléatoire
     ce qui fait qu'on ne pourra pas lister les scores.
     */
    public void sauvegarder() {
        Scores lesScores = Scores.getInstance();
        lesScores.ajouterScore(new Score(j, j.getScore()));
        PersistKit pk;
        HighScore highscore;

        Random r = new Random();
        int alea = r.nextInt(300);
        if (alea <= 100) {
            pk = new XmlKit();
        } else if (alea > 100 && alea <= 200) {
            pk = new XmlKit();
        } else {
            pk = new XmlKit();
        }
        highscore = pk.makeKit();
        highscore.ecrire();

    }

    private Strategie randomStrategie() {
        Strategie st;
        Random r = new Random();
        int alea = r.nextInt(300);
        if (alea <= 100) {
            st = new DeDeuxPuisUn();
            System.out.println("de 2 puis 1");
        } else if (alea > 100 && alea <= 200) {
            st = new DeUnPuisDeux();
            System.out.println("de 1 puis 2");
        } else {
            st = new DeSimultanes();
            System.out.println("de 1 et 2");
        }
        return st;
    }

    public static void main(String[] args) {
        MenuForm mf = new MenuForm();
        mf.setLocationRelativeTo(null);
        mf.setVisible(true);
    }
    
    public Partie getPartie(){
        return this;
    }
    
    public Partie resetPartie(){
        return (new Partie(this.j.getNom()));
    }
}
