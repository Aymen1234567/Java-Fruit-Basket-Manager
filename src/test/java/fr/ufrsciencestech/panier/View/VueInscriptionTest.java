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
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import static org.junit.Assert.*;

public class VueInscriptionTest {

    @Test
    public void testBoutonValiderNonNullEtName() {
        JFrame parent = new JFrame();
        VueInscription vue = new VueInscription(parent);

        assertNotNull(vue.getBtnValider());
        assertEquals("ValiderInscription", vue.getBtnValider().getName());

        vue.dispose();
        parent.dispose();
    }

    @Test
    public void testChampsInitVides() {
        JFrame parent = new JFrame();
        VueInscription vue = new VueInscription(parent);

        assertEquals("", vue.getLogin());
        assertEquals("", vue.getMdp());
        assertEquals("", vue.getMdp2());

        vue.dispose();
        parent.dispose();
    }

    @Test
    public void testSaisieLoginMdpMdp2() {
        JFrame parent = new JFrame();
        VueInscription vue = new VueInscription(parent);

        JTextField tfLogin = null;
        JPasswordField pf1 = null;
        JPasswordField pf2 = null;

        for (java.awt.Component c : vue.getContentPane().getComponents()) {
            if (tfLogin == null) tfLogin = findFirst(JTextField.class, c);
        }

        int pwdFound = 0;
        for (java.awt.Component c : vue.getContentPane().getComponents()) {
            java.util.List<JPasswordField> pfs = findAllPasswordFields(c);
            for (JPasswordField pf : pfs) {
                if (pwdFound == 0) pf1 = pf;
                else if (pwdFound == 1) pf2 = pf;
                pwdFound++;
            }
            if (pf1 != null && pf2 != null) break;
        }

        assertNotNull(tfLogin);
        assertNotNull(pf1);
        assertNotNull(pf2);

        tfLogin.setText("bob");
        pf1.setText("aaa");
        pf2.setText("aaa");

        assertEquals("bob", vue.getLogin());
        assertEquals("aaa", vue.getMdp());
        assertEquals("aaa", vue.getMdp2());

        vue.dispose();
        parent.dispose();
    }

    @Test
    public void testClickValiderExiste() {
        JFrame parent = new JFrame();
        VueInscription vue = new VueInscription(parent);

        JButton valider = vue.getBtnValider();
        assertNotNull(valider);

        valider.doClick();

        vue.dispose();
        parent.dispose();
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

    private static java.util.List<JPasswordField> findAllPasswordFields(java.awt.Component root) {
        java.util.List<JPasswordField> out = new java.util.ArrayList<>();
        collectPasswordFields(root, out);
        return out;
    }

    private static void collectPasswordFields(java.awt.Component root, java.util.List<JPasswordField> out) {
        if (root instanceof JPasswordField) out.add((JPasswordField) root);
        if (root instanceof java.awt.Container) {
            for (java.awt.Component child : ((java.awt.Container) root).getComponents()) {
                collectPasswordFields(child, out);
            }
        }
    }
}

