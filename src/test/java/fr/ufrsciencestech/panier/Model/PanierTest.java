/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.Model;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author celine
 */
public class PanierTest {
    Panier p0, p2, p2plein, p3, p4;
    Fruit o1, o2, o3;
    Fruit b1, b2;
    
    public PanierTest() {
    }
    
    @Before
    public void setUp() throws PanierPleinException {
        p0 = new Panier(0);
        p2 = new Panier(2);
        p2plein = new Panier(2);
        
        p3 = new Panier(3);
        p4 = new Panier(4);

	o1 = new Orange(0.50, "France");
	o2 = new Orange(0.60, "Espagne");
	o3 = new Orange(0.70, "USA");
        
        b1 = new Banane(1.0, "France");
	b2 = new Banane(1.5, "Espagne");
        
        p2plein.add();
        p2plein.add();
    }

    //Mocks :
    //Attention, on ne peut pas mocker les méthodes equals, hashCode, toString, 
    //une classe ou une méthode final, une méthode statique ou privée
    @Test
    public void testGetPriceMock() throws PanierPleinException, PanierVideException {
        System.out.println("GetPrice Mock");
        Fruit mocko1 = mock(Fruit.class);
        Fruit mocko2 = mock(Fruit.class);
        
        when(mocko1.getPrix()).thenReturn(1.0);   //comportement des doublures (stubbing)
        when(mocko2.getPrix()).thenReturn(0.5); 

        Panier panier = new Panier(3);
        panier.add(mocko1);
        panier.add(mocko2);
        double res = panier.getPrice();

        //tests d’interaction :
        verify(mocko1, times(1)).getPrix();    //getPrice() doit avoir été appelé exactement 1 fois
        verify(mocko2, times(1)).getPrix();
        assertTrue(res == 1.5);
        
        panier.remove();
        res = panier.getPrice();
        //tests d’interaction :
        verify(mocko1, times(2)).getPrix();    //getPrice() doit avoir été appelé exactement 2 fois
        verify(mocko2, times(1)).getPrix();
        assertTrue(res == 1.0);
    }
    
    /**
     * Test of getPrix method, of class Panier.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     */
    @Test
    public void testGetPrice() throws PanierPleinException {
        System.out.println("getPrice");
        //panier vide
        double expResult = 0.0;
        double result = p3.getPrice();
        assertTrue(expResult == result);

        //panier à un element à 0.50
        p3.add(o1);
        double expResult2 = 0.50;
        double result2 = p3.getPrice();
        assertTrue(expResult2 == result2);
        
        //panier ou il reste une place
        p3.add(o1);
        double expResult3 = 0.50*2;
        double result3 = p3.getPrice();
        assertTrue(expResult3 == result3);
        
        //panier plein
        p3.add(o1);
        double expResult4 = 0.5*3;
        double result4 = p3.getPrice();
        assertTrue(expResult4 == result4);
        
    }

    /**
     * Test of getSize method, of class Panier.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     */
    @Test
    public void testGetSize() throws PanierPleinException {
        System.out.println("getSize");
        //panier sans place
        int expResult = 0;
        int result = p0.getSize();
        assertTrue(expResult == result);
        
        //panier avec place
        int expResult2 = 0;
        int result2 = p2.getSize();
        assertTrue(expResult2 == result2);
        
        //panier avec place et a 1 element
        p2.add();
        int expResult3 = 1;
        int result3 = p2.getSize();
        assertTrue(expResult3 == result3);
        
        //panier avec place et plein
        p2.add();
        int expResult4 = 2;
        int result4 = p2.getSize();
        assertTrue(expResult4 == result4);
    }
    
    /**
     * Test of getOranges method, of class Panier.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     */
    @Test
    public void testGetOranges() throws PanierPleinException {
        System.out.println("getOranges");
        
        //test dans un panier vide
        Fruit expResult = null;
        Fruit result = p2.getFruits(0);
        Fruit result2 = p2.getFruits(-1);
        Fruit result3 = p2.getFruits(1);
        assertEquals(expResult, result);
        assertEquals(expResult, result2);
        assertEquals(expResult, result3);
        
        //test dans un panier plein
        Fruit expResult4 = new Orange();
        Fruit result4 = p2plein.getFruits(0);
        Fruit result5 = p2plein.getFruits(1);
        assertEquals(expResult4, result4);
        assertEquals(expResult4, result5);
    }
    
    /**
     * Test of getContMax method, of class Panier.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     */
    @Test
    public void testGetContMax() throws PanierPleinException {
        System.out.println("getContMax");
        
        //panier sans place
        int expResult = 0;
        int result = p0.getContMax();
        assertTrue(expResult == result);
        
        //panier vide avec place
        int expResult2 = 2;
        int result2 = p2.getContMax();
        assertTrue(expResult2 == result2);
        
        //panier a 1 element avec place
        p2.add();
        int expResult3 = 2;
        int result3 = p2.getContMax();
        assertTrue(expResult3 == result3);
    }
    
     /**
     * Test of setFruit method, of class Panier.
     */
    @Test
    public void testSetFruit() {
        System.out.println("setFruit");
        
        ArrayList<Fruit> fruitsvide = new ArrayList<Fruit>(4);
        p2.setFruits(fruitsvide);
        assertTrue(p2.estVide());
    }

    /**
     * Test of estVide method, of class Panier.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     */
    @Test
    public void testEstVide() throws PanierPleinException {
        System.out.println("estVide");
        
        //test d'un panier vide
        boolean expResult = true;
        boolean result = p2.estVide();
        assertTrue(expResult == result);
        
        //test d'un panier non vide
        p2.add();
        boolean expResult2 = false;
        boolean result2 = p2.estVide();
        assertTrue(expResult2 == result2);
        
        //test d'un panier plein
        p2.add();
        boolean expResult3 = false;
        boolean result3 = p2.estVide();
        assertTrue(expResult3 == result3);
    }

    /**
     * Test of estPlein method, of class Panier.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     */
    @Test
    public void testEstPlein() throws PanierPleinException {
        System.out.println("estPlein");
        
        //test d'un panier vide
        boolean expResult = false;
        boolean result = p2.estPlein();
        assertTrue(expResult == result);
        
        //test d'un panier non vide
        p2.add();
        boolean expResult2 = false;
        boolean result2 = p2.estPlein();
        assertTrue(expResult2 == result2);
        
        //test d'un panier plein
        p2.add();
        boolean expResult3 = true;
        boolean result3 = p2.estPlein();
        assertTrue(expResult3 == result3);
    }

    /**
     * Test of add method, of class Panier.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     */
    @Test
    public void testAddValide_0args() throws PanierPleinException {
        System.out.println("addOargsValide");
   
        //panier vide
	assertTrue(p4.getSize() == 0);
        
        //test d'ajout de null
        p4.add(null);  
        assertTrue(p4.getSize() == 0);
		
	//test avec panier à une orange
	p4.add(o1);  //1 orange
	assertTrue(p4.getSize() == 1);
        assertEquals(p4.getFruits().get(0), o1);
		
	//test avec un panier où il reste une place
	p4.add(o1);  //2 oranges
	p4.add(o1);	//3 oranges
	assertEquals(p4.getSize(), p4.getContMax()-1);
        assertEquals(p4.getFruits().get(2), o1);
		
	//test que le panier est plein
	p4.add(o1);	//4 oranges
	assertEquals(p4.getSize(), p4.getContMax());
        assertEquals(p4.getFruits().get(3), o1);
    }
    
    /**
     * Test of add method, of class Panier.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     */
    @Test(expected=PanierPleinException.class)
    public void testAddInvalide_0args() throws PanierPleinException {
        System.out.println("addOargsInvalide");
        
        //test avec un panier deja plein
	p2plein.add(o1);
    }

    /**
     * Test of add method, of class Panier.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     */
    @Test
    public void testAddValide_Orange() throws PanierPleinException {
        System.out.println("addOrangeValide");
        
        //test avec panier vide
	assertTrue(p4.getSize() == 0);
		
	//test avec panier à une orange
	p4.add();  //1 orange
	assertTrue(p4.getSize() == 1);
		
	//test avec un panier où il reste une place
	p4.add();  //2 oranges
	p4.add();	//3 oranges
	assertEquals(p4.getSize(), p4.getContMax()-1);
		
	//test que le panier est plein
	p4.add();	//4 oranges
	assertEquals(p4.getSize(), p4.getContMax());
		
    }
    
    /**
     * Test of add method, of class Panier.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     */
    @Test(expected=PanierPleinException.class)
    public void testAddInvalide_Orange() throws PanierPleinException {
        System.out.println("addOrangeInvalide");
	//test avec un panier deja plein
	p2plein.add();		
    }

    /**
     * Test of remove method, of class Panier.
     * @throws fr.ufrsciencestech.panier.Model.PanierVideException
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     */
    @Test
    public void testRemoveValide() throws PanierVideException, PanierPleinException {
        System.out.println("remove");

        //test avec panier à une orange
	p4.add();   //1 orange
        p4.remove(); 
	assertTrue(p4.getSize() == 0);
		
	//test avec un panier plein
	p4.add();  //1 orange
        p4.add();   //2 oranges
	p4.add();	//3 oranges
        p4.add();	//4 oranges
        p4.remove();
	assertEquals(p4.getSize(), p4.getContMax()-1);
    }
    
    /**
     * Test of remove method, of class Panier.
     * @throws fr.ufrsciencestech.panier.Model.PanierVideException
     */
    @Test(expected=PanierVideException.class)
    public void testRemoveInvalide() throws PanierVideException {
        System.out.println("remove");
        p4.remove();
    }

    /**
     * Test of boycottOrigin method, of class Panier.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     */
    @Test
    public void testBoycottOrigin() throws PanierPleinException {
        System.out.println("boycottOrigin");
        //mock
        Fruit mocko1 = mock(Fruit.class);
        Fruit mocko2 = mock(Fruit.class);
        
        when(mocko1.getOrigine()).thenReturn("France");   //comportement des doublures (stubbing)
        when(mocko2.getOrigine()).thenReturn("Espagne"); 

        Panier panier = new Panier(3);
        panier.add(mocko1);
        panier.add(mocko2);
        panier.boycottOrigin("Espagne");

        //tests d’interaction :
        verify(mocko1, times(1)).getOrigine();    //getCountry() doit avoir été appelé exactement 1 fois
        verify(mocko2, times(1)).getOrigine();
        assertTrue(panier.getSize() == 1);
        
        
        //DT chemin limite :
	p4.boycottOrigin("France");  //aucun passage dans le while
	assertTrue(p4.estVide());
		
	//DT 2-chemin
	p4.add(o1);
	p4.add(o2);
	assertTrue(p4.getSize() == 2);
	p4.boycottOrigin("USA");  //2 passages dans le while et aucun retrait (car aucune orange du pays boycotté)
	assertTrue(p4.getSize() == 2);
		
	assertEquals(p4.getFruits(0).getOrigine(), "France");
	p4.boycottOrigin("France");  //2 passages dans le while et 1 retrait (car 1 orange du pays boycotté)
	assertTrue(p4.getSize() == 1);
		
	//DT 1-chemin
	assertEquals(p4.getFruits(0).getOrigine(), "Espagne");
	p4.boycottOrigin("France");  //1 passage dans le while et 0 retrait : DT2
	assertTrue(p4.getSize() == 1); 
		
	p4.boycottOrigin("Espagne");  //1 passage dans le while et 1 retrait (car 1 orange du pays boycotté) : DT1
	assertTrue(p4.estVide()); 
        
        //DT 3-chemin avec 2 fois le pays boycotté
        p4.add(o1);
        p4.add(o2);
        p4.add(o1);
        assertTrue(p4.getSize() == 3);
        p4.boycottOrigin("France");  //3 passages dans le while et 2 retrait (car 2 oranges du pays boycotté)
	assertTrue(p4.getSize() == 1);
        
        //DT 4-chemin avec 3 fois le pays boycotté, car il reste une o2
        p4.add(o1);
        p4.add(o1);
        p4.add(o1);
        assertTrue(p4.getSize() == 4);
        p4.boycottOrigin("France");  //4 passages dans le while et 3 retrait (car 3 oranges du pays boycotté)
	assertTrue(p4.getSize() == 1);
    }

    /**
     * Test of toString method, of class Panier.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     */
    @Test
    public void testToString() throws PanierPleinException {
        System.out.println("toString");
 
        //test panier vide
        String expResultvide = "[]";
        String resultvide = p2.toString();
        assertEquals(expResultvide, resultvide);
        
        //test panier à 1 element
        p2.add(o2);
        String expResult = "[Orange]";
        String result = p2.toString();
        assertEquals(expResult, result);
        
        //test panier plein
        p4.add(o1);
        p4.add(b2);
        String expResult2 = "[Orange, Banane]";
        String result2 = p4.toString();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of equals method, of class Panier.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     * @throws fr.ufrsciencestech.panier.Model.PanierVideException
     */
    @Test
    public void testEquals() throws PanierPleinException, PanierVideException {
        System.out.println("equals");
        
        //test avec null
        Panier pnull = null;
        assertFalse(p2.equals(pnull));
        
        //tests de 2 paniers vides
        assertTrue(p2.getSize() == p4.getSize());
        assertTrue(p2.equals(p4));
        
        //test de 2 paniers avec 1 meme element 
        p2.add(o1);
        p4.add(o1);
        assertTrue(p2.getSize() == p4.getSize());
        assertTrue(p2.equals(p4));
    
        //test de 2 paniers avec les 3 memes elements 
        p3.add(o1);
        p3.add(o1);
        p3.add(o2);
            
        p4.add(o1);
        p4.add(o2);
        assertTrue(p3.getSize() == p4.getSize());
        assertTrue(p3.equals(p4));
        
        //test de 2 paniers avec le meme nb mais pas les memes oranges
        p3.remove();
        p3.add(o3);
        assertTrue(p3.getSize() == p4.getSize());
        assertFalse(p3.equals(p4));
        
        //test de 2 paniers avec le meme nb mais pas les memes oranges
        p3.remove();
        p3.add(new Orange(0.60, "France"));
        assertTrue(p3.getSize() == p4.getSize());
        assertFalse(p3.equals(p4));
        
        //test de 2 paniers avec le meme nb mais pas les memes oranges
        p3.remove();
        p3.add(new Orange(0.80, "Espagne"));
        assertTrue(p3.getSize() == p4.getSize());
        assertFalse(p3.equals(p4));
        
        //test de 2 paniers ayant un nb différents d'elements
        p4.add(o2);
        assertTrue(p2.getSize() != p4.getSize());
        assertFalse(p2.equals(p4));
    }
    
     /**
     * Test of nbFruits method, of class Panier.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     */
    @Test
    public void testNbFruits() throws PanierPleinException{
        System.out.println("nbFruits");

        p4.add(o1);
        p4.add(b1);
        p4.add(o2);
        p4.add(b2);
        int expOranges = 1;
        int expBananes = 1;
        int resultOranges = p4.nbFruits(o1);
        int resultBananes = p4.nbFruits(b1);
        assertTrue(expOranges==resultOranges);
        assertTrue(expBananes==resultBananes);
    }
}
