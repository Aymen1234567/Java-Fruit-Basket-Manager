/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.Model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author celine
 */
public abstract class FruitSimpleTest {
    //FruitSimple fs;
    // the factory methods
    abstract FruitSimple createFruit(double price, String country);
    abstract FruitSimple createFruitNull();

    @Before
    public void setUp() {
        
    }
    
    // all test methods need to make use of the factory method to create the instance of a fruit
    @Test
    public void testGetPrix() {
        System.out.println("getPrice");
        FruitSimple fs = createFruit(0.5, "France");
        double expected = 0.5;
        double result = fs.getPrix();
        assertTrue(expected == result);
        
        //prix négatif
        FruitSimple fsn = createFruit(-0.5, "France");
        expected = 0.5;
        result = fsn.getPrix();
        assertTrue(expected == result);
    }
    
    @Test
    public void testGetOrigine() {
        System.out.println("getCountry");
        FruitSimple fs = createFruit(0.5, "France");
        String expected = "France";
        String result = fs.getOrigine();
        assertEquals(expected, result);
    }
    
    @Test
    public void testEquals() {
        System.out.println("equals");
        FruitSimple fs = createFruit(0.5, "France");
        FruitSimple fseq = createFruit(0.5, "France");
        FruitSimple fsnull = createFruitNull();
        
        //test avec un Fruit null
        assertFalse(fs.equals(fsnull));
        //test de 2 Fruits equivalents
        assertTrue(fs.equals(fseq));
        //test de 2 Fruits non equivalents : prix different
        assertFalse(fs.equals(createFruit(1.0, "France")));
        //test de 2 Fruits non equivalents : origine differente
        assertFalse(fs.equals(createFruit(0.5, "Espagne")));
        //les 2
        assertFalse(fs.equals(createFruit(1.0, "Espagne")));
    }
    
    /**
     * Test of toString method
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        FruitSimple fs = createFruit(0.5, "France");
        String expResult = fs.getClass().getSimpleName();
        String result = fs.toString();
        assertEquals(expResult, result);
    }
}
