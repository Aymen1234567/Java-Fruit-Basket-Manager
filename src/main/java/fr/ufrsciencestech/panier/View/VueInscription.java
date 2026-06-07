/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.View;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author wg203076
 */
public class VueInscription extends JDialog {
    private JTextField champLogin;
    private JPasswordField champMdp;
    private JPasswordField champMdp2;
    private JButton btnAnnuler;
    private JButton btnValider;

    public VueInscription(JFrame parent) {
        super(parent, "Créer un compte", true);   // modal

        champLogin = new JTextField(15);
        champMdp = new JPasswordField(15);
        champMdp2 = new JPasswordField(15);

        btnAnnuler = new JButton("Annuler");
        btnValider = new JButton("Valider");

        btnAnnuler.setName("AnnulerInscription");
        btnValider.setName("ValiderInscription");

        JPanel centre = new JPanel(new GridLayout(3, 2, 10, 10));
        centre.add(new JLabel("Login : "));
        centre.add(champLogin);
        centre.add(new JLabel("Mot de passe : "));
        centre.add(champMdp);
        centre.add(new JLabel("Confirmer mot de passe : "));
        centre.add(champMdp2);

        JPanel bas = new JPanel(new FlowLayout());
        bas.add(btnAnnuler);
        bas.add(btnValider);

        setLayout(new BorderLayout(10, 10));
        add(centre, BorderLayout.CENTER);
        add(bas, BorderLayout.SOUTH);

        // annuler ferme la fenêtre
        btnAnnuler.addActionListener(e -> dispose());

        pack();
        setLocationRelativeTo(parent);
    }

    public String getLogin() {
        return champLogin.getText();
    }

    public String getMdp() {
        return new String(champMdp.getPassword());
    }

    public String getMdp2() {
        return new String(champMdp2.getPassword());
    }

    public JButton getBtnValider() {
        return btnValider;
    }
}
