package fr.ufrsciencestech.panier.Controler;

import fr.ufrsciencestech.panier.Model.*;
import fr.ufrsciencestech.panier.View.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
wg203076
*/
public class ControleurAuth implements ActionListener {

    private final GestionUtilisateurs gest;
    
    private final VueConnexion vueConnexion;
    private VueGraphiqueListe vg;
    

    
    private Panier panier;
    private VueGraphiqueListe vueListe;
    private ControleurListe controleurListe;

    public ControleurAuth(GestionUtilisateurs gest, VueConnexion vueConnexion) {
        this.gest = gest;
        this.vueConnexion = vueConnexion;

        vueConnexion.getBtnConnexion().addActionListener(this);
        vueConnexion.getBtnCreerCompte().addActionListener(this);
    }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = ((JButton)e.getSource()).getName();

        switch (name) {
            case "Connexion":
                gererConnexion();
                break;

            case "CreerCompte":
                gererInscription();
                break;
       
        }
    }
public void retourConnexion() {
    vueConnexion.setVisible(true);
}
protected void afficherMessage(String message) {
    JOptionPane.showMessageDialog(vueConnexion, message);
}

    private void gererConnexion() {
    String login = vueConnexion.getLogin();
    String mdp = vueConnexion.getMdp();

    if (gest.verifierConnexion(login, mdp)) {
        afficherMessage("Connexion réussie !");
        vueConnexion.setVisible(false);
        ouvrirApplicationPrincipale();
    } else {
        afficherMessage("Login ou mot de passe incorrect");
    }
}

    private void gererInscription() {
        VueInscription dialog = new VueInscription(vueConnexion);

        dialog.getBtnValider().addActionListener(ev -> {
            String l = dialog.getLogin();
            String m1 = dialog.getMdp();
            String m2 = dialog.getMdp2();

            if (!m1.equals(m2)) {
                JOptionPane.showMessageDialog(dialog, "Les mots de passe ne correspondent pas");
                return;
            }

            if (gest.ajouterUtilisateur(l, m1)) {
                JOptionPane.showMessageDialog(dialog, "Compte créé !");
                dialog.dispose();
            } else {
                JOptionPane.showMessageDialog(dialog, "Ce login existe déjà");
            }
        });

        dialog.setVisible(true);
    }

  
    protected void ouvrirApplicationPrincipale() {
        if (panier == null) {    
            
            panier = new Panier(4);

            vueListe = new VueGraphiqueListe();
            
            Fruit o = new Orange();
            vueListe.addListeFruits(o);
            Fruit b = new Banane();
            vueListe.addListeFruits(b);
            Fruit c = new Cerise();
            vueListe.addListeFruits(c);

            // === contrôleur ===
            controleurListe = new ControleurListe();
            controleurListe.setPanier(panier);
            controleurListe.setVue(vueListe);
            controleurListe.setAuth(this);
            panier.addObserver(vueListe);   
            vueListe.addControleur(controleurListe);
        }

        vueListe.setVisible(true);  
    }
}
