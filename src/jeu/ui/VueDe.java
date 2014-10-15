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

    

    @Override
    public void update(Observable o, Object arg) {
    LancerForm lf = LancerForm.getForm();
        if (((De) o).getId() == 1) {
            lf.setValeurDe1((Integer) arg);
        } else {
            lf.setValeurDe2((Integer) arg);
        }

    }

}
