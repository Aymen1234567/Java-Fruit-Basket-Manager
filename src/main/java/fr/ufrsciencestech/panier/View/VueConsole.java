/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.View;

import fr.ufrsciencestech.panier.Model.Panier;
//import java.util.Observable;
//import java.util.Observer;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 *
 * @author zb783864
 */




public class VueConsole implements PropertyChangeListener {
    private String trace;

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

 public VueConsole(){
    trace = "Contenance initiale : " + 0;
}
    
@Override
public void propertyChange(PropertyChangeEvent evt) {
    Panier p = (Panier) evt.getSource();
    Integer nb = (Integer) p.getSize();
    setTrace("Nouvelle contenance : " + nb.toString());
}

}

