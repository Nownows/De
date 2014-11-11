/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.ui;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Main
 */
public class VuePartie  implements Observer{
    LancerForm2 lf;

    @Override
    public void update(Observable o, Object arg) {
        lf = LancerForm2.getForm();
        lf.setNbLancer((int) arg);
        if ((int) arg == 0){
            lf.setBtnLancerDesactiver();
            lf.setBtnFinPartie();
        }
    }
}
