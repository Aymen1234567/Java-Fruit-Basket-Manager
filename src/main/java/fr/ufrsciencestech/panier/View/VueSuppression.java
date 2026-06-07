
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.View;


import fr.ufrsciencestech.panier.Model.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author mr647037
 */
public class VueSuppression extends JDialog{
    private final JButton btn_quitter;
    private final JButton btn_valider;
    private final JComboBox<Fruit> cmb_fruits;
    private boolean valide = false;
    
    public VueSuppression(VueGraphiqueListe parent)
    {
        JComboBox<Fruit> liste = parent.getListeAdd(); //récupère la liste de fruits disponibles du Frame père
        cmb_fruits = new JComboBox<Fruit>();
        for(int i=0 ; i<liste.getItemCount() ; i++)
        {
            cmb_fruits.addItem(liste.getItemAt(i));
        }
        cmb_fruits.setRenderer((list, value, index, isSelected, cellHasFocus) -> {
            javax.swing.JLabel lbl = new javax.swing.JLabel();
            if (value != null) {
                lbl.setText(formatFruit(value));
            }
            return lbl;
        });
        
        btn_quitter = new JButton("Quitter");
        btn_valider = new JButton("Valider");
       
        
        //Haut de la vue
        JPanel nord = new JPanel(new BorderLayout());
        nord.add(new JLabel("Sélectionner un fruit à supprimer de la vente"));
        
        //Bas de la vue
        JPanel sud = new JPanel(new GridLayout(1, 2, 10, 10));
        sud.add(btn_quitter);
        sud.add(btn_valider);
        
        //Centre de la vue
        JPanel centre = new JPanel(new FlowLayout());
        centre.add(cmb_fruits);
        
        //Assemblage
        setLayout(new BorderLayout(10, 10));
        add(nord, BorderLayout.NORTH);
        add(centre, BorderLayout.CENTER);
        add(sud, BorderLayout.SOUTH);
        
        // Action boutons de base
        btn_quitter.addActionListener(e ->
        {
            valide = false;
            dispose();
        });
        
        btn_valider.addActionListener(e -> 
        {
            valide = true;
            dispose();
        });

        pack();                // adapte la taille à son contenu
        setLocationRelativeTo(parent); 
    }
    
    public boolean isValide() 
    {
        return valide;
    } 
    
    public Fruit getSelectedFruit()
    {
        return (Fruit) cmb_fruits.getSelectedItem();
    }
    
    public JButton getBoutonValider()
    {
        return btn_valider;
    }
    
    private String formatFruit(Fruit f) {
        if (f == null) return "";
        return f.getClass().getSimpleName() + " (" + f.getOrigine() + ")";
    }
}
