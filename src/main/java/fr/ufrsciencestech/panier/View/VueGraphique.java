/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.View;

import fr.ufrsciencestech.panier.Controler.Controleur;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
//import java.util.Observable;
//import java.util.Observer;

/**
 *
 * @author celine
 */
public interface VueGraphique extends PropertyChangeListener {//extends Observer {
    @Override
    public void propertyChange(PropertyChangeEvent evt);
    //public void update(Observable m, Object o);
    
    public void addControleur(Controleur c);
}
