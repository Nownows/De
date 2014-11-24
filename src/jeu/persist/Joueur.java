package jeu.persist;

import java.io.Serializable;
import java.util.Observable;

public class Joueur extends Observable implements Serializable{

    String nom;
    int score;

    public Joueur(String nom, int score) {
        this.nom = nom;
        this.score = score;
    }
    
    public String getNom(){
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public void addScore(int score){
        this.score += score;
        setChanged();
        notifyObservers(this.score);
    }
    
    public int getScore(){
        return this.score;
    }
}
