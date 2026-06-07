/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.View;

/**
 *
 * @author wg203076
 */


import javax.swing.*;
import java.awt.*;

public class VueConnexion extends JFrame {
    private JTextField champLogin;
    private JPasswordField champMdp;
    private JButton btnConnexion;
    private JButton btnCreerCompte;

    public VueConnexion() {
        super("Connexion");

        champLogin = new JTextField(15);
        champMdp = new JPasswordField(15);
        btnConnexion = new JButton("Se connecter");
        btnCreerCompte = new JButton("Créer un compte");

        btnConnexion.setName("Connexion");
        btnCreerCompte.setName("CreerCompte");

        JPanel centre = new JPanel(new GridLayout(2, 2, 10, 10));
        centre.add(new JLabel("Login : "));
        centre.add(champLogin);
        centre.add(new JLabel("Mot de passe : "));
        centre.add(champMdp);

        JPanel bas = new JPanel(new FlowLayout());
        bas.add(btnCreerCompte);
        bas.add(btnConnexion);

        setLayout(new BorderLayout(10, 10));
        add(centre, BorderLayout.CENTER);
        add(bas, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);   // centre l'écran
        setVisible(true);
    }

    public String getLogin() {
        return champLogin.getText();
    }

    public String getMdp() {
        return new String(champMdp.getPassword());
    }

    public JButton getBtnConnexion() {
        return btnConnexion;
    }

    public JButton getBtnCreerCompte() {
        return btnCreerCompte;
    }
}
