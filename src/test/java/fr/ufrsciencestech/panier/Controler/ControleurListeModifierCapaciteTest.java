/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author wg203076
 */
package fr.ufrsciencestech.panier.Controler;

import fr.ufrsciencestech.panier.Model.Panier;
import fr.ufrsciencestech.panier.View.VueGraphiqueListe;
import fr.ufrsciencestech.panier.View.VueModifierCapacite;
import org.junit.Before;
import org.junit.Test;

import javax.swing.JButton;
import java.awt.event.ActionEvent;

import static org.mockito.Mockito.*;

public class ControleurListeModifierCapaciteTest {

    private ControleurListe ctrl;
    private Panier p;
    private VueGraphiqueListe vue;

    @Before
    public void setUp() {
        ctrl = spy(new ControleurListe());
        p = mock(Panier.class);
        vue = mock(VueGraphiqueListe.class);

        ctrl.setPanier(p);
        ctrl.setVue(vue);

        when(p.getContMax()).thenReturn(4);
    }

    @Test
    public void testClickModifierCapacite_ouvreDialog() {
        VueModifierCapacite dialog = mock(VueModifierCapacite.class);
        JButton btnValider = new JButton();
        when(dialog.getBtnValider()).thenReturn(btnValider);

        doReturn(dialog).when(ctrl).creerDialogModifierCapacite(eq(vue), eq(4));

        JButton source = new JButton();
        source.setName("ModifierCapacite");

        ctrl.actionPerformed(new ActionEvent(source, ActionEvent.ACTION_PERFORMED, ""));

        verify(ctrl, times(1)).creerDialogModifierCapacite(vue, 4);
        verify(dialog, times(1)).setVisible(true);
    }

@Test
public void testModifierCapacite_validerModifiePanier() {

    Panier p = mock(Panier.class);
    VueGraphiqueListe vue = mock(VueGraphiqueListe.class);

    ControleurListe ctrl = spy(new ControleurListe());
    ctrl.setPanier(p);
    ctrl.setVue(vue);

    VueModifierCapacite dialog = mock(VueModifierCapacite.class);
    JButton btnValider = new JButton();

    when(dialog.getNouvelleCapacite()).thenReturn(10);
    when(dialog.getBtnValider()).thenReturn(btnValider);

    doReturn(dialog).when(ctrl)
        .creerDialogModifierCapacite(any(), anyInt());

    JButton source = new JButton();
    source.setName("ModifierCapacite");

    ctrl.actionPerformed(new ActionEvent(source, ActionEvent.ACTION_PERFORMED, ""));

    btnValider.doClick();

    verify(p, times(1)).setContMax(10);
}
}

