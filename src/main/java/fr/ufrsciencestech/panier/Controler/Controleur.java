/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.Controler;

import fr.ufrsciencestech.panier.Model.Panier;
import java.awt.event.ActionListener;
/**
 *
 * @author celine
 */
public abstract class Controleur implements ActionListener{
    protected Panier p;
    
    public void setPanier(Panier p){
        this.p = p;
    }
}
