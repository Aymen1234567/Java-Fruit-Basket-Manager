/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.View;

import fr.ufrsciencestech.panier.Model.*;
import org.junit.Before;
import java.beans.PropertyChangeEvent;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author celine
 */
public class VueConsoleTest {
    VueConsole vuec;
    Panier p;
    
    public VueConsoleTest() {
    }
    
    @Before
    public void setUp() {
        vuec = new VueConsole();
        p = new Panier(2);
        p.addObserver(vuec);
    }
    
    @Test
    public void testGetTrace() {
        System.out.println("getTrace");
        String expected = vuec.getTrace();
        assertEquals(expected, "Contenance initiale : " + 0);
    }
    
    @Test
    public void testSetTrace() {
        System.out.println("setTrace");
        String trace = "Contenance initiale : " + 2;
        vuec.setTrace(trace);
        String expected = vuec.getTrace();
        assertEquals(expected, trace);
    }

    /**
     * Test of update method, of class VueConsole.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     * @throws fr.ufrsciencestech.panier.Model.PanierVideException
     */
    @Test
    public void testUpdate() throws PanierPleinException, PanierVideException {
        System.out.println("update");
        p.add();
        assertEquals(vuec.getTrace(), "Nouvelle contenance : " + 1);
        p.add();
        assertEquals(vuec.getTrace(), "Nouvelle contenance : " + 2);
    }
    
    @Test
public void testAffichageVide() {
    VueConsole v = new VueConsole();
    assertEquals("Contenance initiale : 0", v.getTrace());
}

}
