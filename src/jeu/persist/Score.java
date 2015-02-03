package jeu.persist;

import java.io.Serializable;
import java.util.Date;

public class Score implements Serializable{

    private Joueur j;
    private int score;
    private Date dateScore;

    public Score(Joueur j, int score) {
        this.j = j;
        this.score = score;
        dateScore = new Date();
    }

    public Joueur getJ() {
        return j;
    }

    public void setJ(Joueur j) {
        this.j = j;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getDateScore() {
        return dateScore;
    }

    public void setDateScore(Date dateScore) {
        this.dateScore = dateScore;
    }

}
