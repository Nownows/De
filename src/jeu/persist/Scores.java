package jeu.persist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Scores implements Serializable{

    List<Score> lesScores;
    private static Scores INSTANCE = new Scores();


    public Scores(){
         lesScores = new ArrayList<>();
    }

    public void ajouterScore(Score s) {
        lesScores.add(s);
    }

    public List<Score> getLesScores() {
        return lesScores;
    }

    public void setLesScores(List<Score> lesScores) {
        this.lesScores = lesScores;
    }

    public static Scores getInstance() {
        return INSTANCE;
    }
}
