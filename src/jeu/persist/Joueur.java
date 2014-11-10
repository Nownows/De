/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.persist;

import java.util.Observable;

/**
 *
 * @author ASUS
 */
public class Joueur extends Observable{

    String nom;
    int score;

    public Joueur(String nom, int score) {
        this.nom = nom;
        this.score = score;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public void addScore(int score){
        this.score += score;
        setChanged();
        notifyObservers(score);
    }
}
