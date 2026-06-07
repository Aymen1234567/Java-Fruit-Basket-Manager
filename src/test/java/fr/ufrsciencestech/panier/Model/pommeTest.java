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
 * Test de la classe pomme
 * @author zb783864
 */
public class pommeTest extends FruitSimpleTest {

    // Implémentation des méthodes abstraites de la factory
    @Override
    FruitSimple createFruit(double price, String country) {
        return new pomme(price, country);
    }

    @Override
    FruitSimple createFruitNull() {
        return null;
    }

    @Before
    @Override
    public void setUp() {
        // Rien de spécifique à ajouter pour pomme
    }

    /**
     * Test du constructeur avec chaîne vide pour l'origine
     * (initAttributes gère déjà le cas null/empty → origine par défaut "France")
     */
    @Test
    public void testChaineVide() {
        System.out.println("chaine vide");
        pomme instance = new pomme(0.8, "");
        String expResult = "France";
        String result = instance.getOrigine();
        assertEquals(expResult, result);
    }
    public void testSetCountry() {
        System.out.println("setCountry");
        pomme instance = new pomme(1.0,"");
        String expResult = "France";
        instance.setOrigine("France");
        String result = instance.getOrigine();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        pomme instance = new pomme(1.0,"");
        double expResult = 0.7;
        instance.setPrix(0.7);
        double result = instance.getPrix();
        assertTrue(expResult == result);
    }
    /**
     * Test de la méthode isSeedless : une pomme a des pépins → false
     */
    @Test
    public void testIsSeedless() {
        System.out.println("isSeedless");
        pomme instance = new pomme(1.0, "Espagne");
        boolean expResult = false;
        boolean result = instance.isSeedless();
        assertEquals(expResult, result);
    }

}