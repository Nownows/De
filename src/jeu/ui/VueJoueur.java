/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeu.ui;

import java.util.Observable;
import java.util.Observer;

public class VueJoueur implements Observer{

    @Override
    public void update(Observable o, Object arg) {
         LancerForm2 lf = LancerForm2.getForm();
         lf.changerScore((int) arg);
    }
    
}
