/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.View;

import fr.ufrsciencestech.panier.Controler.ControleurListe;
import fr.ufrsciencestech.panier.Model.Fruit;
//import fr.ufrsciencestech.panier.Model.ListeVideException;
import fr.ufrsciencestech.panier.Model.Orange;
import fr.ufrsciencestech.panier.Model.Panier;
import fr.ufrsciencestech.panier.Model.PanierPleinException;
import fr.ufrsciencestech.panier.Model.PanierVideException;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author zineb
 */
public class VueGraphiqueListeTest {
    static VueGraphiqueListe vueg;
    private ControleurListe c1;
    private Panier p;

    @Before
    public void setUp() {
        vueg = new VueGraphiqueListe();
        Fruit o = (Fruit)new Orange();
        vueg.addListeFruits(o);   
        p = new Panier(2);
        c1 = new ControleurListe();
        c1.setPanier(p);
        c1.setVue(vueg);
        p.addObserver(vueg);
        vueg.addControleur(c1);
    }

    /**
     * Test of update method, of class VueGraphiqueSimple.
     * @throws fr.ufrsciencestech.panier.Model.PanierPleinException
     * @throws fr.ufrsciencestech.panier.Model.PanierVideException
     */
 @Test
public void testUpdate() throws PanierPleinException, PanierVideException, BadLocationException {
    p.add();

    int debut1l = vueg.getAffiche().getLineStartOffset(0);
    int fin1l = vueg.getAffiche().getLineEndOffset(0);

    assertEquals("Panier de 1 fruits : 0.5 euros\n",
                 vueg.getAffiche().getText(debut1l, fin1l));

    p.add();

    fin1l = vueg.getAffiche().getLineEndOffset(0);
    assertEquals("Panier de 2 fruits : 1.0 euros\n",
                 vueg.getAffiche().getText(debut1l, fin1l));

vueg.getAffiche().setText("Panier de 0 fruits\n");
assertEquals("Panier de 0 fruits\n", vueg.getAffiche().getText());

}

    /**
     * Test of addControleur method, of class VueGraphiqueSimple.
     * @throws javax.swing.text.BadLocationException
     */
    @Test
    public void testAdd() throws BadLocationException {
        System.out.println("add");
        assertNotNull(vueg);  
        JTextArea res = (JTextArea)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); 
        final JButton plus = (JButton)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);

        int debut1l = res.getLineStartOffset(0);
        int fin1l = res.getLineEndOffset(0);
        assertEquals(res.getText(debut1l, fin1l), "Panier de 0 fruits\n");

        plus.doClick();
        fin1l = res.getLineEndOffset(0);
        assertEquals(res.getText(debut1l, fin1l), "Panier de 1 fruits : 0.5 euros\n");
        
        plus.doClick();
        fin1l = res.getLineEndOffset(0);
        assertEquals(res.getText(debut1l, fin1l), "Panier de 2 fruits : 1.0 euros\n");
    }
    
    @Test
    public void testAddPlein() throws BadLocationException {
        System.out.println("addplein");
        assertNotNull(vueg);  
        JTextArea res = (JTextArea)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); 
        final JButton plus = (JButton)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);

        int debut1l = res.getLineStartOffset(0);
        int fin1l = res.getLineEndOffset(0);
        assertEquals(res.getText(debut1l, fin1l), "Panier de 0 fruits\n");

        
        plus.doClick();
        fin1l = res.getLineEndOffset(0);
        assertEquals(res.getText(debut1l, fin1l), "Panier de 1 fruits : 0.5 euros\n");
        
        plus.doClick();
        fin1l = res.getLineEndOffset(0);
        assertEquals(res.getText(debut1l, fin1l), "Panier de 2 fruits : 1.0 euros\n");
        
        plus.doClick();
        fin1l = res.getLineEndOffset(0);
        assertEquals(res.getText(debut1l, fin1l), "Panier de 2 fruits : 1.0 euros\n");
    }
    
  
    @Test
    public void testRemoveOk() throws BadLocationException {
        System.out.println("remove");
        assertNotNull(vueg);  
        JTextArea res = (JTextArea)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); 
        final JButton plus = (JButton)TestUtils.getChildNamed(vueg, "Plus");
        assertNotNull(plus);
        final JButton minus = (JButton)TestUtils.getChildNamed(vueg, "Minus");
        assertNotNull(minus);
        
     
        plus.doClick();
        int debut1l = res.getLineStartOffset(0);
        int fin1l = res.getLineEndOffset(0);
        assertEquals(res.getText(debut1l, fin1l), "Panier de 1 fruits : 0.5 euros\n");
        
        minus.doClick();
        fin1l = res.getLineEndOffset(0);
        assertEquals(res.getText(debut1l, fin1l), "Panier de 0 fruits\n");
    }
    
    @Test
    public void testRemoveZero() throws BadLocationException {
        System.out.println("remove");
        assertNotNull(vueg);  
        JTextArea res = (JTextArea)TestUtils.getChildNamed(vueg, "Affichage");
        assertNotNull(res); 
        final JButton minus = (JButton)TestUtils.getChildNamed(vueg, "Minus");
        assertNotNull(minus);
        
        int debut1l = res.getLineStartOffset(0);
        int fin1l = res.getLineEndOffset(0);
        assertEquals(res.getText(debut1l, fin1l), "Panier de 0 fruits\n");
        
        minus.doClick();
        fin1l = res.getLineEndOffset(0);
        assertEquals(res.getText(debut1l, fin1l), "Panier de 0 fruits\n");
    }
}
    


