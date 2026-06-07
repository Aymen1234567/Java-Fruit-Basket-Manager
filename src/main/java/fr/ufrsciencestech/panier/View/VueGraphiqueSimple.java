/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.View;

import fr.ufrsciencestech.panier.Controler.Controleur;
import fr.ufrsciencestech.panier.Model.Panier;
import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author celine
 */
public class VueGraphiqueSimple extends JFrame implements VueGraphique {
    private final JButton inc;
    private final JButton dec;
    private JLabel affiche;
    /**
     * @return the inc
     */
    
    public JButton getInc() {
        return inc;
    }

    /**
     * @return the dec
     */
    public JButton getDec() {
        return dec;
    }

    /**
     * @return the affiche
     */
    public JLabel getAffiche() {
        return affiche;
    }

    /**
     * @param affiche the affiche to set
     */
    public void setAffiche(JLabel affiche) {
        this.affiche = affiche;
    }

    public VueGraphiqueSimple(){
        super("Panier");
        inc = new JButton("+");
        dec = new JButton("-");
        affiche = new JLabel("0", JLabel.CENTER);
        
        add(inc, BorderLayout.NORTH);
        add(dec, BorderLayout.SOUTH);
        add(affiche, BorderLayout.CENTER);
        
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
