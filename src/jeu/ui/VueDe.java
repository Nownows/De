/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.ui;

import java.util.Observable;
import java.util.Observer;
import jeu.core.De;

public class VueDe implements Observer {
    LancerForm2 lf;

    public VueDe() {
        lf = LancerForm2.getForm();
    }
    
    @Override
    public void update(Observable o, Object arg) {
        lf.setScoreLancer(((De) o).getId(), (Integer) arg);
    }

}
