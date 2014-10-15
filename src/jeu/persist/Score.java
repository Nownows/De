package jeu.persist;

import java.util.Date;

public class Score {
    private Joueur j;
    private int score;
    private Date dateScore;

    public Score(Joueur j, int score, Date dateScore) {
        this.j = j;
        this.score = score;
        this.dateScore = dateScore;
    }
    
    
}
