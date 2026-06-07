/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.View;

/**
 *
 * @author tg843121
 */
import javax.swing.*;
import java.awt.*;
public class VueBoycott extends JDialog {
    private final JComboBox<String> origine;
    private final JButton quitter;
    private final JButton valider;
    private boolean valide;
    public VueBoycott(Frame parent){
        super(parent,"Boycott",true);
        //Declaration des elements de la vue
        origine = new JComboBox<>(new String[]{"France", "Espagne", "Maroc","Senegal","Brezil"});
        quitter = new JButton("Quitter");
        valider = new JButton("Valider");
        JPanel sud = new JPanel(new GridLayout(1, 2, 10, 10));
        
        //Haut de la vue
        JPanel nord = new JPanel(new BorderLayout());
        nord.add(new JLabel("Sélectionner une origine à boycotter"));
        
        //Bas de la vue
        sud.add(quitter);
        sud.add(valider);
        //Assemblage
        setLayout(new BorderLayout(10, 10));
        add(nord, BorderLayout.NORTH);
        add(origine, BorderLayout.CENTER);
        add(sud, BorderLayout.SOUTH);
        // Action boutons de base
        quitter.addActionListener(e -> {
            valide = false;
            setVisible(false);
        });

        valider.addActionListener(e -> {
            valide = true;
            setVisible(false);
        });

        pack();                // adapte la taille à son contenu
        setLocationRelativeTo(parent); 
    }
    public boolean isValide() {
        return valide;
    }

    public String getOrigineSelectionnee() {
        return (String) origine.getSelectedItem();
    }
}
