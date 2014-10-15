package jeu.persist;

import java.util.ArrayList;
import java.util.List;

public class Scores {
    List<Score> lesScores;
    
    public Scores(){
        lesScores = new ArrayList<>();
        // TODO load BDD
    }
    
    public void ajouterScore(Score s){
        lesScores.add(s);
    }
}
