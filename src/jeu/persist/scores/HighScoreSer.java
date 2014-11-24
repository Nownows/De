/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.persist.scores;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import jeu.persist.Joueur;
import jeu.persist.Scores;


/**
 *
 * @author Main
 */
public class HighScoreSer extends HighScore {

    @Override
    public void ecrire() {
        ObjectOutputStream oos = null;
        try {
            File fichier = new File("save.sav");
            oos = new ObjectOutputStream(new FileOutputStream(fichier));
            Scores lesScores = Scores.getInstance();
            oos.writeObject(lesScores) ;
            System.out.println("sauvegardé en fichier");
        } catch (IOException ex) { 
            Logger.getLogger(HighScoreJDBC.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(HighScoreJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
