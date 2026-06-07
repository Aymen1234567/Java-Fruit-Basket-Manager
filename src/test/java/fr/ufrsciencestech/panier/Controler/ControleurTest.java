/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.Controler;

import fr.ufrsciencestech.panier.View.VueGraphiqueSimple;
import fr.ufrsciencestech.panier.Model.PanierPleinException;
import fr.ufrsciencestech.panier.Model.Panier;
import java.awt.event.ActionEvent;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author celine
 */
//plus besoin de cette classe de tests
public class ControleurTest {
    ControleurSimple c1;
    Controleur c2;
    Panier p, p4;
    VueGraphiqueSimple vueg;
    ActionEvent einc;
    ActionEvent edec;

    public ControleurTest() {
    }
    
    @Before
    public void setUp(){
        c1 = new ControleurSimple();
        c2 = new ControleurSimple();
        p = new Panier(2);
        p4 = new Panier(4);
        vueg = new VueGraphiqueSimple(); 
        c1.setPanier(p);
        
        edec = new ActionEvent(vueg.getDec(), 1, "dec");
        einc = new ActionEvent(vueg.getInc(), 0, "inc");
    }

    /**
     * Test of actionPerformed method, of class Controleur.
     */
    @Test   //ignore pour fonctionner dans Jenkins
    public void testActionPerformed() {
        System.out.println("actionPerformed");

        assertTrue(p.estVide());
        c1.actionPerformed(einc);
        assertTrue(p.getSize()==1);

        c1.actionPerformed(edec);
        assertTrue(p.estVide());
    }
    
    /**
     * Test of actionPerformed method, of class Controleur.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     */
    @Test   //ignore pour fonctionner dans Jenkins
    public void testActionPerformedPlein() throws PanierPleinException {
        System.out.println("actionPerformedPlein");
        
        p.add();
        p.add();
        assertTrue(p.getSize() == 2);
        c1.actionPerformed(einc);
        assertTrue(p.getSize() == 2);
    }
    
    /**
     * Test of actionPerformed method, of class Controleur.
     */
    @Test  //ignore pour fonctionner dans Jenkins
    public void testActionPerformedVide() {
        System.out.println("actionPerformedVide");

        assertTrue(p.estVide());
        c1.actionPerformed(edec);
        assertTrue(p.estVide());
    }

    /**
     * Test of setPanier method, of class Controleur.
     */
    @Test  //ignore pour fonctionner dans Jenkins
    public void testSetPanier() {
        System.out.println("setPanier");
        c1.setPanier(p4);
        c1.actionPerformed(einc);
        assertTrue(p4.getSize() == 1);
    }
}
