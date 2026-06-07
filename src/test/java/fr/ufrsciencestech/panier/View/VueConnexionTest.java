/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author wg203076
 */
package fr.ufrsciencestech.panier.View;

import org.junit.Test;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import static org.junit.Assert.*;

public class VueConnexionTest {

    @Test
    public void testBoutonsEtNamesNonNull() {
        VueConnexion vue = new VueConnexion();

        assertNotNull(vue.getBtnConnexion());
        assertNotNull(vue.getBtnCreerCompte());
        assertEquals("Connexion", vue.getBtnConnexion().getName());
        assertEquals("CreerCompte", vue.getBtnCreerCompte().getName());

        vue.dispose();
    }

    @Test
    public void testLoginEtMdpInitVides() {
        VueConnexion vue = new VueConnexion();

        assertEquals("", vue.getLogin());
        assertEquals("", vue.getMdp());

        vue.dispose();
    }

    @Test
    public void testSaisieLoginEtMdp() {
        VueConnexion vue = new VueConnexion();

        JTextField tfLogin = null;
        JPasswordField pfMdp = null;

        for (java.awt.Component c : vue.getContentPane().getComponents()) {
            tfLogin = findFirst(JTextField.class, c);
            if (tfLogin != null) break;
        }
        for (java.awt.Component c : vue.getContentPane().getComponents()) {
            pfMdp = findFirst(JPasswordField.class, c);
            if (pfMdp != null) break;
        }

        assertNotNull(tfLogin);
        assertNotNull(pfMdp);

        tfLogin.setText("alice");
        pfMdp.setText("pass");

        assertEquals("alice", vue.getLogin());
        assertEquals("pass", vue.getMdp());

        vue.dispose();
    }

    @Test
    public void testClickBoutonsExiste() {
        VueConnexion vue = new VueConnexion();

        JButton b1 = vue.getBtnConnexion();
        JButton b2 = vue.getBtnCreerCompte();

        assertNotNull(b1);
        assertNotNull(b2);

        b1.doClick();
        b2.doClick();

        vue.dispose();
    }

    private static <T> T findFirst(Class<T> clazz, java.awt.Component root) {
        if (clazz.isInstance(root)) return clazz.cast(root);
        if (root instanceof java.awt.Container) {
            for (java.awt.Component child : ((java.awt.Container) root).getComponents()) {
                T found = findFirst(clazz, child);
                if (found != null) return found;
            }
        }
        return null;
    }
}

