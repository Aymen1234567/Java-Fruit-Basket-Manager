/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author zb783864
 */
package fr.ufrsciencestech.panier.View;

import org.junit.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VueCreerFruitTest {

    private JFrame parent;
    private VueCreerFruit vue;

    @Before
    public void initialisation() throws Exception {
        Assume.assumeFalse(GraphicsEnvironment.isHeadless());
        SwingUtilities.invokeAndWait(() -> {
            parent = new JFrame();
            vue = new VueCreerFruit(parent);
        });
    }

    @After
    public void nettoyage() throws Exception {
        if (GraphicsEnvironment.isHeadless()) return;
        SwingUtilities.invokeAndWait(() -> {
            if (vue != null) vue.dispose();
            if (parent != null) parent.dispose();
        });
    }

    @Test
    public void etatInitial_invalide() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            assertFalse(vue.isValide());
            assertNotNull(vue.getTypeSelectionne());
            assertNotNull(vue.getOrigineSelectionnee());
            assertTrue(vue.getPrixSaisi() > 0);
        });
    }

    @Test
    public void clicQuitter_invalide() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            JButton quitter = boutonParTexte(vue, "Quitter");
            assertNotNull(quitter);
            quitter.doClick();
            assertFalse(vue.isValide());
        });
    }

    @Test
    public void clicValider_valide() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            JButton valider = boutonParTexte(vue, "Valider");
            assertNotNull(valider);
            valider.doClick();
            assertTrue(vue.isValide());
        });
    }

    @Test
    public void valeursSelectionnees_retournees() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            List<JComboBox<?>> combos = combos(vue);
            assertTrue(combos.size() >= 2);

            JComboBox<?> type = combos.get(0);
            JComboBox<?> origine = combos.get(1);

            JSpinner prix = spinner(vue);
            assertNotNull(prix);

            type.setSelectedItem("Kiwi");
            origine.setSelectedItem("Maroc");
            prix.setValue(2.5);

            assertEquals("Kiwi", vue.getTypeSelectionne());
            assertEquals("Maroc", vue.getOrigineSelectionnee());
            assertEquals(2.5, vue.getPrixSaisi(), 0.001);
        });
    }

    @Test
    public void prix_limites() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            JSpinner prix = spinner(vue);
            assertNotNull(prix);

            prix.setValue(0.1);
            assertEquals(0.1, vue.getPrixSaisi(), 0.001);

            prix.setValue(100.0);
            assertEquals(100.0, vue.getPrixSaisi(), 0.001);
        });
    }

    private static JButton boutonParTexte(Container racine, String texte) {
        for (Component c : composants(racine)) {
            if (c instanceof JButton) {
                JButton b = (JButton) c;
                if (texte.equals(b.getText())) return b;
            }
        }
        return null;
    }

    private static List<JComboBox<?>> combos(Container racine) {
        List<JComboBox<?>> res = new ArrayList<>();
        for (Component c : composants(racine)) {
            if (c instanceof JComboBox) res.add((JComboBox<?>) c);
        }
        return res;
    }

    private static JSpinner spinner(Container racine) {
        for (Component c : composants(racine)) {
            if (c instanceof JSpinner) return (JSpinner) c;
        }
        return null;
    }

    private static List<Component> composants(Container racine) {
        List<Component> res = new ArrayList<>();
        for (Component c : racine.getComponents()) {
            res.add(c);
            if (c instanceof Container) res.addAll(composants((Container) c));
        }
        return res;
    }
}

