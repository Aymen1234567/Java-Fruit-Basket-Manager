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
public class FraiseTest extends FruitSimpleTest{
    // implementation of the abstract factory methods
    @Override
    FruitSimple createFruit(double price, String country) {
        return new Fraise(price, country);
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
        Fraise instance = new Fraise(4.0,"");
        String expResult = "Espagne";
        String result = instance.getOrigine();
        assertEquals(expResult, result);
    }

    /**
     * Test of isSeedless method, of class Fraise.
     */
    @Test
    public void testIsSeedless() {
        System.out.println("isSeedless");
        Fraise instance = new Fraise();
        boolean expResult = true;
        boolean result = instance.isSeedless();
        assertEquals(expResult, result);
    }
}
