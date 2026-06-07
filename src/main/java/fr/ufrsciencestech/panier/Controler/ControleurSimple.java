/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.Controler;


import fr.ufrsciencestech.panier.Model.PanierPleinException;
import fr.ufrsciencestech.panier.Model.PanierVideException;
import java.awt.Component;
import java.awt.event.ActionEvent;

/**
 *
 * @author celine
 */
public class ControleurSimple extends Controleur{
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(((Component)e.getSource()).getName().equals("Plus"))
            try {
                p.add();
        } catch (PanierPleinException ex) {
            //JOptionPane.showMessageDialog(null, "Panier plein", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
        else
            try {
                p.remove();
        } catch (PanierVideException ex) {
            //JOptionPane.showMessageDialog(null, "Panier vide", "Erreur", JOptionPane.ERROR_MESSAGE) ;
        }
            
    }
}
