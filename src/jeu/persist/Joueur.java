package jeu.persist;

import java.util.Observable;

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
        notifyObservers(this.score);
    }
}
