package fr.ufrsciencestech.panier.Controler;

import fr.ufrsciencestech.panier.Model.Panier;
import fr.ufrsciencestech.panier.View.VueBoycott;
import fr.ufrsciencestech.panier.View.VueGraphiqueListe;

import org.junit.Before;
import org.junit.Test;

import javax.swing.JButton;
import java.awt.event.ActionEvent;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ControleurListeBoycottTest {

    private ControleurListe ctrl;
    private VueGraphiqueListe vue;
    private Panier panier;

    @Before
    public void setUp() {
        panier = new Panier(10);

        vue = mock(VueGraphiqueListe.class);

        ctrl = spy(new ControleurListe());
        ctrl.setPanier(panier);
        ctrl.setVue(vue);
    }

    @Test
    public void testBoycottAnnuleNeFaitRien() {
        VueBoycott dialog = mock(VueBoycott.class);
        when(dialog.isValide()).thenReturn(false);

        doReturn(dialog).when(ctrl).creerDialogBoycott(any());

        JButton source = new JButton();
        source.setName("Boycott");

        ctrl.actionPerformed(
                new ActionEvent(source, ActionEvent.ACTION_PERFORMED, "")
        );

        verify(vue, never()).Boycott(any());
    }

    @Test
    public void testBoycottValideAppelleVue() {
        VueBoycott dialog = mock(VueBoycott.class);
        when(dialog.isValide()).thenReturn(true);
        when(dialog.getOrigineSelectionnee()).thenReturn("Espagne");

        doReturn(dialog).when(ctrl).creerDialogBoycott(any());

        JButton source = new JButton();
        source.setName("Boycott");

        ctrl.actionPerformed(
                new ActionEvent(source, ActionEvent.ACTION_PERFORMED, "")
        );

        verify(vue, times(1)).Boycott("Espagne");
    }

    @Test
    public void testBoycottOrigineTransmiseCorrectement() {
        VueBoycott dialog = mock(VueBoycott.class);
        when(dialog.isValide()).thenReturn(true);
        when(dialog.getOrigineSelectionnee()).thenReturn("Maroc");

        doReturn(dialog).when(ctrl).creerDialogBoycott(any());

        JButton source = new JButton();
        source.setName("Boycott");

        ctrl.actionPerformed(
                new ActionEvent(source, ActionEvent.ACTION_PERFORMED, "")
        );

        verify(vue).Boycott(eq("Maroc"));
    }
}
