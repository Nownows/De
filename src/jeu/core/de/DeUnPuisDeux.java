/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.core.de;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Main
 */
public class DeUnPuisDeux implements Strategie {

    @Override
    public int lancerLesDes(De d1, De d2) {
        try {
            int v1, v2;
            v1 = d1.lancer();
            Thread.sleep(500);
            v2 = d2.lancer();
            return v1 + v2;
        } catch (InterruptedException ex) {
            Logger.getLogger(DeUnPuisDeux.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
