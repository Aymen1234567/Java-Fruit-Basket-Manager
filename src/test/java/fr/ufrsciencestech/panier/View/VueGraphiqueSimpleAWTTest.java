/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.View;

import fr.ufrsciencestech.panier.Controler.ControleurSimple;
import fr.ufrsciencestech.panier.Model.Panier;
import fr.ufrsciencestech.panier.Model.PanierPleinException;
import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author celine
 */
public class VueGraphiqueSimpleAWTTest {
    static VueGraphiqueSimpleAWT vueg;
    private ControleurSimple c1;
    private Panier p;
    
    @Before
    public void setUp() {
        vueg = new VueGraphiqueSimpleAWT();
        p = new Panier(2);
        c1 = new ControleurSimple();
        c1.setPanier(p);
        //c1.setVue(vueg);
        p.addObserver(vueg);
        vueg.addControleur(c1);
    }

    /**
     * Test of update method, of class VueGraphiqueSimpleAWT.
     */
    @Test
    public void testUpdate() throws PanierPleinException {
        System.out.println("update");
        p.add();
        assertEquals(vueg.getAffiche().getText(), "1");
        p.add();
        assertEquals(vueg.getAffiche().getText(), "2");
        
        vueg.setAffiche(new Label("0", Label.CENTER));
        assertEquals(vueg.getAffiche().getText(), "0");
    }

    /**
     * Test of addControleur method, of class VueGraphiqueSimple.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        assertNotNull(vueg);  // Instantiated?
        Label res = (Label)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final Button plus = (Button)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        
        //tests d'acceptation (de l'interface) : 
        //plus.doClick(); //ne marche pas avec AWT
        ActionEvent ae = new ActionEvent((Object)plus, ActionEvent.ACTION_PERFORMED, "");
        plus.dispatchEvent(ae);  
        
        assertEquals(res.getText(), "1");
        plus.dispatchEvent(ae);    //plus.doClick();
        assertEquals(res.getText(), "2");
    }

    @Test
    public void testRemoveOk() {
        System.out.println("remove");
        assertNotNull(vueg);  // Instantiated?
        Label res = (Label)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final Button plus = (Button)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        final Button minus = (Button)TestUtils.getChildNamed(vueg, "Minus");
        assertNotNull(minus);
        
        //tests d'acceptation (de l'interface) : 
        //plus.doClick(); //ne marche pas avec AWT
        ActionEvent aep = new ActionEvent((Object)plus, ActionEvent.ACTION_PERFORMED, "");
        ActionEvent aem = new ActionEvent((Object)minus, ActionEvent.ACTION_PERFORMED, "");
        plus.dispatchEvent(aep); 
        assertEquals(res.getText(), "1");
        minus.dispatchEvent(aem);   //minus.doClick();
        assertEquals(res.getText(), "0");
    }
    
    @Test
    public void testRemoveZero() {
        System.out.println("remove");
        assertNotNull(vueg);  // Instantiated?
        Label res = (Label)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); // Component found?
        final Button minus = (Button)TestUtils.getChildNamed(vueg, "Minus");
        assertNotNull(minus);
        
        //tests d'acceptation (de l'interface) : 
        ActionEvent aem = new ActionEvent((Object)minus, ActionEvent.ACTION_PERFORMED, "");
        minus.dispatchEvent(aem);   //minus.doClick();
        assertEquals(res.getText(), "0");
    }
}
