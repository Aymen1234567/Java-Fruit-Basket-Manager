/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author wg203076
 */
package fr.ufrsciencestech.panier.View;

import org.junit.Assume;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

public class VueModifierCapaciteTest {

    @Test
    public void testCreationVue() throws Exception {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());

        final VueModifierCapacite[] vue = new VueModifierCapacite[1];

        SwingUtilities.invokeAndWait(() -> {
            JFrame parent = new JFrame();
            vue[0] = new VueModifierCapacite(parent, 5);
        });

        assertNotNull(vue[0]);
        vue[0].dispose();
    }

    @Test
    public void testCapaciteInitiale() throws Exception {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());

        final VueModifierCapacite[] vue = new VueModifierCapacite[1];

        SwingUtilities.invokeAndWait(() -> {
            JFrame parent = new JFrame();
            vue[0] = new VueModifierCapacite(parent, 8);
        });

        assertEquals(8, vue[0].getNouvelleCapacite());
        vue[0].dispose();
    }

    @Test
    public void testBoutonValiderExiste() throws Exception {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());

        final VueModifierCapacite[] vue = new VueModifierCapacite[1];

        SwingUtilities.invokeAndWait(() -> {
            JFrame parent = new JFrame();
            vue[0] = new VueModifierCapacite(parent, 3);
        });

        JButton btn = vue[0].getBtnValider();
        assertNotNull(btn);
        assertEquals("ValiderCapacite", btn.getName());
        vue[0].dispose();
    }
}
