/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.persist.factory;

import jeu.persist.scores.HighScore;
import jeu.persist.scores.HighScoreXML;


/**
 *
 * @author Srcvk
 */
public class XmlKit extends PersistKit {

    @Override
    public HighScore makeKit() {
        HighScore h = new HighScoreXML();
        return h;
    }

}
