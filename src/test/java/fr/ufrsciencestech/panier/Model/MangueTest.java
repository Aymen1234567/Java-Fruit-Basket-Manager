/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.Model;

/**
 *
 * @author zb783864
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MangueTest extends FruitSimpleTest {

    @Override
    FruitSimple createFruit(double price, String country) {
        return new Mangue(price, country);
    }

    @Override
    FruitSimple createFruitNull() {
        return null;
    }

    @Before
    @Override
    public void setUp() {}

    @Test
    public void testChaineVide() {
        System.out.println("chaine vide");
        Mangue instance = new Mangue(2.0, "");
        String expResult = "Brésil"; 
        assertEquals(expResult, instance.getOrigine());
    }

    @Test
    public void testIsSeedless() {
        System.out.println("isSeedless");
        Fruit f = new Mangue();
        assertFalse(f.isSeedless());
    }
}

