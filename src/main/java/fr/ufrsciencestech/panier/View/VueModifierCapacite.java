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

public class VueModifierCapacite extends JDialog {

    private JSpinner spinnerCapacite;
    private JButton btnValider;
    private JButton btnAnnuler;

    public VueModifierCapacite(JFrame parent, int capaciteActuelle) {
        super(parent, "Modifier capacité du panier", true);   // true = modal

        spinnerCapacite = new JSpinner(
                new SpinnerNumberModel(capaciteActuelle, 1, 999, 1)
        );

        btnValider = new JButton("Valider");
        btnAnnuler = new JButton("Annuler");

        btnValider.setName("ValiderCapacite");
        btnAnnuler.setName("AnnulerCapacite");

        JPanel centre = new JPanel(new GridLayout(2, 2, 10, 10));
        centre.add(new JLabel("Capacité actuelle :"));
        centre.add(new JLabel(String.valueOf(capaciteActuelle)));
        centre.add(new JLabel("Nouvelle capacité :"));
        centre.add(spinnerCapacite);

        JPanel bas = new JPanel();
        bas.add(btnAnnuler);
        bas.add(btnValider);

        setLayout(new BorderLayout(10, 10));
        add(centre, BorderLayout.CENTER);
        add(bas, BorderLayout.SOUTH);

        btnAnnuler.addActionListener(e -> dispose());

        pack();
        setLocationRelativeTo(parent);
    }

    public int getNouvelleCapacite() {
        return (Integer) spinnerCapacite.getValue();
    }

    public JButton getBtnValider() {
        return btnValider;
    }
}
