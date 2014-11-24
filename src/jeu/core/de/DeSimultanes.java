/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeu.core.de;

import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Main
 */
public class DeSimultanes implements Strategie{

    @Override
    public int lancerLesDes(De d1, De d2) {
        int v1,v2;
        v1 = d1.lancer();
        v2 = d2.lancer();
        return v1+v2;
    } 
}
