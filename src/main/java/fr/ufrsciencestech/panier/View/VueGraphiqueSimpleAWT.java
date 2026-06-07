/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.View;

import fr.ufrsciencestech.panier.Controler.Controleur;
import fr.ufrsciencestech.panier.Model.Panier;
import java.awt.BorderLayout;
import java.util.Observable;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
/**
 *
 * @author celine
 */
public class VueGraphiqueSimpleAWT extends Frame implements VueGraphique{
    private final Button inc;
    private final Button dec;
    private Label affiche;
    /**
     * @return the inc
     */
    public Button getInc() {
        return inc;
    }
    
    /**
     * @return the dec
     */
    public Button getDec() {
        return dec;
    }
    
    /**
     * @return the affiche
     */
    public Label getAffiche() {
        return affiche;
    }
    /**
     * @param affiche the affiche to set
     */
    public void setAffiche(Label affiche) {
        this.affiche = affiche;
    }

    public VueGraphiqueSimpleAWT(){
        super("Panier");
        inc = new Button("+");
        dec = new Button("-");
        affiche = new Label("0", Label.CENTER);
        add(inc, BorderLayout.NORTH);
        add(dec, BorderLayout.SOUTH);
        add(affiche, BorderLayout.CENTER);
        
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        this.pack();
        this.setVisible(true);
        
       
        inc.setName("Plus");
        dec.setName("Minus");
        affiche.setName("Affichage");
    }

    /*@Override
    public void update(Observable m, Object o) {
        Panier p = (Panier) m;
        getAffiche().setText(((Integer)p.getFruits().size()).toString());
    }*/
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
	//System.out.println("Change " + evt.getPropertyName());
	//System.out.println("\t(" + evt.getOldValue() + 
	//						" -> " + evt.getNewValue() + ")");
	//System.out.println("Property in object " + evt.getSource());
        Panier p = (Panier) evt.getSource();
        getAffiche().setText(((Integer)p.getFruits().size()).toString());
    }

    @Override
    public void addControleur(Controleur c) {
        getInc().addActionListener(c);
        getDec().addActionListener(c);
    }
}
