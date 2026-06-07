/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author roudet
 */
public class OrangeTest extends FruitSimpleTest{
    // implementation of the abstract factory methods
    @Override
    FruitSimple createFruit(double price, String country) {
        return new Orange(price, country);
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
        Orange instance = new Orange(1.0,"");
        String expResult = "Espagne";
        String result = instance.getOrigine();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetCountry() {
        System.out.println("setCountry");
        Orange instance = new Orange(1.0,"");
        String expResult = "France";
        instance.setOrigine("France");
        String result = instance.getOrigine();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        Orange instance = new Orange(1.0,"");
        double expResult = 0.7;
        instance.setPrix(0.7);
        double result = instance.getPrix();
        assertTrue(expResult == result);
    }
    
    /**
     * Test of isSeedless method, of class Orange.
     */
    @Test
    public void testIsSeedless() {
        System.out.println("isSeedless");
        Fruit instanceavecpepins = new Orange();
        boolean expResult1 = false;
        boolean result1 = instanceavecpepins.isSeedless();
        assertTrue(expResult1 == result1);
    }
}
