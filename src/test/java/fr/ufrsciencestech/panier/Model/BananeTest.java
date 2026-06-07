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
public class BananeTest extends FruitSimpleTest {
    // implementation of the abstract factory methods
    @Override
    FruitSimple createFruit(double price, String country) {
        return new Banane(price, country);
    }
    
    @Override
    FruitSimple createFruitNull(){
        return null;
    }

    @Before
    @Override
    public void setUp(){
    }
    
    @Test
    public void testChaineVide() {
        System.out.println("chaine vide");
        Banane instance = new Banane(0.5,"");
        String expResult = "France";
        String result = instance.getOrigine();
        assertEquals(expResult, result);
    }

    /**
     * Test of isSeedless method, of class Banane.
     */
    @Test
    public void testIsSeedless() {
        System.out.println("isSeedless");
        Fruit instancesspepins = new Banane();
        boolean expResult2 = true;
        boolean result2 = instancesspepins.isSeedless();
        assertTrue(expResult2 == result2);
    }
}
