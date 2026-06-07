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
public class CeriseTest extends FruitSimpleTest{
    
    // implementation of the abstract factory methods
    @Override
    FruitSimple createFruit(double price, String country) {
        return new Cerise(price, country);
    }
    
    @Override
    FruitSimple createFruitNull(){
        return null;
    }

    @Before
    @Override
    public void setUp() {
    }
    
    @Test
    public void testChaineVide() {
        System.out.println("chaine vide");
        Cerise instance = new Cerise(0.5,"");
        String expResult = "France";
        String result = instance.getOrigine();
        assertEquals(expResult, result);
    }

    /**
     * Test of isSeedless method, of class Cerise.
     */
    @Test
    public void testIsSeedless() {
        System.out.println("isSeedless");
        Fruit instanceavecpepins = new Cerise();
        boolean expResult1 = false;
        boolean result1 = instanceavecpepins.isSeedless();
        assertTrue(expResult1 == result1);
    }
}
