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

public class CitronTest extends FruitSimpleTest {

    @Override
    FruitSimple createFruit(double price, String country) {
        return new Citron(price, country);
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
        Citron instance = new Citron(0.8, "");
        String expResult = "Senegal"; 
        assertEquals(expResult, instance.getOrigine());
    }

    @Test
    public void testIsSeedless() {
        System.out.println("isSeedless");
        Fruit f = new Citron();
        assertFalse(f.isSeedless());
    }
}
