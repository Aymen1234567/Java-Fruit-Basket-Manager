/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.View;

import fr.ufrsciencestech.panier.Model.PanierVideException;
import fr.ufrsciencestech.panier.Model.PanierPleinException;
import fr.ufrsciencestech.panier.Controler.ControleurSimple;
import fr.ufrsciencestech.panier.Model.Panier;
import javax.swing.JButton;
import javax.swing.JLabel;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author celine
 */
public class VueGraphiqueSimpleTest {
    private static VueGraphiqueSimple vueg;
    private ControleurSimple c1;
    private Panier p;  

    @Before
    public void setUp() {
        vueg = new VueGraphiqueSimple();
        p = new Panier(2);
        /*p = mock(Panier.class);
        when(p.getSize()).thenReturn(0); 
        when(p.getContMax()).thenReturn(2); 
        when(p.toString()).thenReturn("test"); */
        
        c1 = new ControleurSimple();
        c1.setPanier(p);
        p.addObserver(vueg);
        vueg.addControleur(c1);
    }


    /**
     * Test of update method, of class VueGraphiqueSimple.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     * @throws fr.ufrsciencestech.panier.Model.PanierVideException
     */
    @Test  //ignore pour fonctionner dans Jenkins
    public void testUpdate() throws PanierPleinException, PanierVideException {
        System.out.println("update");
        p.add();
        assertEquals(vueg.getAffiche().getText(), "1");
        p.add();
        assertEquals(vueg.getAffiche().getText(), "2");
        
        vueg.setAffiche(new JLabel("0", JLabel.CENTER));
        assertEquals(vueg.getAffiche().getText(), "0");
    }

    /**
     * Test of addControleur method, of class VueGraphiqueSimple.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        assertNotNull(vueg);  // Instantiated?
        JLabel res = (JLabel)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final JButton plus = (JButton)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        
        //tests d'acceptation (de l'interface) : 
        plus.doClick();
        assertEquals(res.getText(), "1");
        plus.doClick();
        assertEquals(res.getText(), "2");
    }
    
    @Test
    public void testAddPlein() {
        System.out.println("addplein");
        assertNotNull(vueg);  // Instantiated?
        JLabel res = (JLabel)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final JButton plus = (JButton)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        
        //tests d'acceptation (de l'interface) : 
        plus.doClick();
        assertEquals(res.getText(), "1");
        plus.doClick();
        assertEquals(res.getText(), "2");
        plus.doClick();
        assertEquals(res.getText(), "2");
    }
    
    //https://www.javaworld.com/article/2073056/swing-gui-programming/automate-gui-tests-for-swing-applications.html
    @Test
    public void testRemoveOk() {
        System.out.println("remove");
        assertNotNull(vueg);  // Instantiated?
        JLabel res = (JLabel)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final JButton plus = (JButton)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        final JButton minus = (JButton)TestUtils.getChildNamed(vueg, "Minus");
        assertNotNull(minus);
        
        //tests d'acceptation (de l'interface) : 
        plus.doClick();
        assertEquals(res.getText(), "1");
        minus.doClick();
        assertEquals(res.getText(), "0");
    }
    
    @Test
    public void testRemoveZero() {
        System.out.println("remove");
        assertNotNull(vueg);  // Instantiated?
        JLabel res = (JLabel)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final JButton minus = (JButton)TestUtils.getChildNamed(vueg, "Minus");
        assertNotNull(minus);
        
        //tests d'acceptation (de l'interface) : 
        minus.doClick();
        assertEquals(res.getText(), "0");
    }
}
