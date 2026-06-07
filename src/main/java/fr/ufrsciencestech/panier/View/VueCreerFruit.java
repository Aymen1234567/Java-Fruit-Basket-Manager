/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.View;

/**
 *
 * @author zb783864
 */


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class VueCreerFruit extends JDialog {

    private final JComboBox<String> typeFruit;
    private final JSpinner prix;
    private final JComboBox<String> origine;
    private final JButton quitter;
    private final JButton valider;

   
    private boolean valide = false;

    public VueCreerFruit(Frame parent) {
        super(parent, "Créer un fruit", true);   

       typeFruit = new JComboBox<>(new String[]{
    "Orange",
    "Pomme",
    "Banane",
    "Kiwi",
    "Citron",
    "Mangue",
    "Ananas",
    "Fraise",
    "Cerise"
});

        prix = new JSpinner(new SpinnerNumberModel(1.0, 0.1, 100.0, 0.1));
        origine = new JComboBox<>(new String[]{"France", "Espagne", "Maroc","Senegal","Brezil"});

        quitter = new JButton("Quitter");
        valider = new JButton("Valider");

      
        JPanel panelLabels = new JPanel(new GridLayout(1, 3, 20, 0));
        panelLabels.add(new JLabel("Type de fruit :"));
        panelLabels.add(new JLabel("Prix du fruit :"));
        panelLabels.add(new JLabel("Origine du fruit :"));

        
        JPanel panelChamps = new JPanel(new GridLayout(1, 3, 20, 0));
        panelChamps.add(typeFruit);

        JPanel panelPrix = new JPanel(new FlowLayout());
        panelPrix.add(prix);
        panelPrix.add(new JLabel("€"));
        panelChamps.add(panelPrix);

        panelChamps.add(origine);

       
        JPanel panelBoutons = new JPanel(new FlowLayout());
        panelBoutons.add(quitter);
        panelBoutons.add(valider);

       
        setLayout(new BorderLayout(10, 10));
        add(panelLabels, BorderLayout.NORTH);
        add(panelChamps, BorderLayout.CENTER);
        add(panelBoutons, BorderLayout.SOUTH);

       
        quitter.addActionListener(e -> {
            valide = false;
            setVisible(false);
        });

        valider.addActionListener(e -> {
            valide = true;
            setVisible(false);
        });

        pack();
        setLocationRelativeTo(parent);
    }

    

    public boolean isValide() {
        return valide;
    }

    public String getTypeSelectionne() {
        return (String) typeFruit.getSelectedItem();
    }

    public double getPrixSaisi() {
        return ((Number) prix.getValue()).doubleValue();
    }

    public String getOrigineSelectionnee() {
        return (String) origine.getSelectedItem();
    }
}
