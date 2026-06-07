package fr.ufrsciencestech.panier.Controler;

import fr.ufrsciencestech.panier.Model.*;
import fr.ufrsciencestech.panier.View.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionEvent;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
/*
zb783864
*/
public class ControleurListeCreeFruitTest {

    private Panier panier;
    private VueGraphiqueListe vue;
    private ControleurListe ctrl;

    private JComboBox<Fruit> combo;

    @Before
    public void setUp() {
        panier = new Panier(10);

        vue = mock(VueGraphiqueListe.class);
        combo = new JComboBox<>();

        when(vue.getListeAdd()).thenReturn(combo);

        doAnswer(invocation -> {
            Fruit f = (Fruit) invocation.getArguments()[0];
            combo.addItem(f);
            return null;
        }).when(vue).addListeFruits(any(Fruit.class));

        ctrl = spy(new ControleurListe());
        ctrl.setPanier(panier);
        ctrl.setVue(vue);
    }

    private void clickCreerFruit() {
        JButton source = new JButton();
        source.setName("CreerFruit");
        ctrl.actionPerformed(new ActionEvent(source, ActionEvent.ACTION_PERFORMED, ""));
    }

    @Test
    public void testCreationFruitAnnuleeNeModifieRien() {
        VueCreerFruit dialog = mock(VueCreerFruit.class);
        doNothing().when(dialog).setVisible(true);
        when(dialog.isValide()).thenReturn(false);

        doReturn(dialog).when(ctrl).creerDialog(any());

        int avant = combo.getItemCount();
        clickCreerFruit();
        int apres = combo.getItemCount();

        assertEquals(avant, apres);
        verify(vue, never()).addListeFruits(any());
    }

    @Test
    public void testCreationFruitKiwiAjouteDansListe() {
        VueCreerFruit dialog = mock(VueCreerFruit.class);
        doNothing().when(dialog).setVisible(true);

        when(dialog.isValide()).thenReturn(true);
        when(dialog.getTypeSelectionne()).thenReturn("Kiwi");
        when(dialog.getPrixSaisi()).thenReturn(2.5);
        when(dialog.getOrigineSelectionnee()).thenReturn("Italie");

        doReturn(dialog).when(ctrl).creerDialog(any());

        clickCreerFruit();

        assertEquals(1, combo.getItemCount());
        Fruit f = combo.getItemAt(0);

        assertTrue(f instanceof Kiwi);
        assertEquals(2.5, f.getPrix(), 0.001);
        assertEquals("Italie", f.getOrigine());
    }

    @Test
    public void testCreationFruitMangueAjouteDansListe() {
        VueCreerFruit dialog = mock(VueCreerFruit.class);
        doNothing().when(dialog).setVisible(true);

        when(dialog.isValide()).thenReturn(true);
        when(dialog.getTypeSelectionne()).thenReturn("Mangue");
        when(dialog.getPrixSaisi()).thenReturn(3.0);
        when(dialog.getOrigineSelectionnee()).thenReturn("Mexique");

        doReturn(dialog).when(ctrl).creerDialog(any());

        clickCreerFruit();

        assertEquals(1, combo.getItemCount());
        Fruit f = combo.getItemAt(0);

        assertTrue(f instanceof Mangue);
        assertEquals(3.0, f.getPrix(), 0.001);
        assertEquals("Mexique", f.getOrigine());
    }

    @Test
    public void testCreationFruitTypeInconnuNeRajouteRien() {
        VueCreerFruit dialog = mock(VueCreerFruit.class);
        doNothing().when(dialog).setVisible(true);

        when(dialog.isValide()).thenReturn(true);
        when(dialog.getTypeSelectionne()).thenReturn("Pasteque");
        when(dialog.getPrixSaisi()).thenReturn(1.0);
        when(dialog.getOrigineSelectionnee()).thenReturn("France");

        doReturn(dialog).when(ctrl).creerDialog(any());

        clickCreerFruit();

        assertEquals(0, combo.getItemCount());
        verify(vue, never()).addListeFruits(any());
    }
}
