/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author wg203076
 */
package fr.ufrsciencestech.panier.Controler;

import fr.ufrsciencestech.panier.Model.GestionUtilisateurs;
import fr.ufrsciencestech.panier.View.VueConnexion;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.*;

public class ControleurAuthTest {


 @Test
public void testConnexionReussie() {
    GestionUtilisateurs gest = mock(GestionUtilisateurs.class);
    VueConnexion vue = mock(VueConnexion.class);

    JButton btnConnexion = new JButton();
    btnConnexion.setName("Connexion");

    when(vue.getBtnConnexion()).thenReturn(btnConnexion);
    when(vue.getBtnCreerCompte()).thenReturn(new JButton());
    when(vue.getLogin()).thenReturn("alice");
    when(vue.getMdp()).thenReturn("pass");

    when(gest.verifierConnexion("alice", "pass")).thenReturn(true);

    ControleurAuth ctrl = spy(new ControleurAuth(gest, vue));

    doNothing().when(ctrl).afficherMessage(anyString());
    doNothing().when(ctrl).ouvrirApplicationPrincipale();

    ctrl.actionPerformed(new ActionEvent(btnConnexion, ActionEvent.ACTION_PERFORMED, ""));

    verify(gest, times(1)).verifierConnexion("alice", "pass");
    verify(vue, times(1)).setVisible(false);
    verify(ctrl, times(1)).ouvrirApplicationPrincipale();
    verify(ctrl, times(1)).afficherMessage("Connexion réussie !");
}


@Test
public void testConnexionEchouee() {
    GestionUtilisateurs gest = mock(GestionUtilisateurs.class);
    VueConnexion vue = mock(VueConnexion.class);

    JButton btnConnexion = new JButton();
    btnConnexion.setName("Connexion");

    when(vue.getBtnConnexion()).thenReturn(btnConnexion);
    when(vue.getBtnCreerCompte()).thenReturn(new JButton());

    when(vue.getLogin()).thenReturn("alice");
    when(vue.getMdp()).thenReturn("bad");

    when(gest.verifierConnexion("alice", "bad")).thenReturn(false);

    ControleurAuth ctrl = spy(new ControleurAuth(gest, vue));

    doNothing().when(ctrl).afficherMessage(anyString());

    ctrl.actionPerformed(new ActionEvent(btnConnexion, ActionEvent.ACTION_PERFORMED, ""));

    verify(gest, times(1)).verifierConnexion("alice", "bad");
    verify(vue, never()).setVisible(false);
    verify(ctrl, never()).ouvrirApplicationPrincipale();
    verify(ctrl, times(1)).afficherMessage("Login ou mot de passe incorrect");
}

}




