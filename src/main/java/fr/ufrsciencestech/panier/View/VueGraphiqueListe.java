/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.View;

import fr.ufrsciencestech.panier.Controler.Controleur;
import fr.ufrsciencestech.panier.Model.Fruit;
import fr.ufrsciencestech.panier.Model.Orange;
import fr.ufrsciencestech.panier.Model.Banane;
import fr.ufrsciencestech.panier.Model.FruitSimple;
import fr.ufrsciencestech.panier.Model.pomme;
import fr.ufrsciencestech.panier.Model.Cerise;
import fr.ufrsciencestech.panier.Model.Ananas;
import fr.ufrsciencestech.panier.Model.Fraise;
import fr.ufrsciencestech.panier.Model.Kiwi;
import fr.ufrsciencestech.panier.Model.Citron;
import fr.ufrsciencestech.panier.Model.ListeVideException;
import fr.ufrsciencestech.panier.Model.Mangue;

import fr.ufrsciencestech.panier.Model.Panier;
import fr.ufrsciencestech.panier.Model.PanierPleinException;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.beans.PropertyChangeEvent;
//import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author zb783864
 */

public class VueGraphiqueListe extends JFrame implements VueGraphique {

    private final JButton inc;
    private final JButton dec;
    private final JComboBox<Fruit> listeFruits;
    private final JTextArea affichenb;

    private final JButton b1;          // Boycott
    private final JButton b2;          // Modifier capacité
    private final JButton creerFruit;  // Créer fruit
    private final JButton deconnexion;
    private final JButton bouton_suppression;

    public VueGraphiqueListe() {
        super("Panier");

        inc = new JButton("ajout fruit");
        dec = new JButton("retirer fruit");
        affichenb = new JTextArea("Panier de 0 fruits\n");
        deconnexion= new JButton("Deconnexion");

        b1 = new JButton("Boycotter un fruit");
        b2 = new JButton("Modifier capacité");
        creerFruit = new JButton("Créer fruit");
        bouton_suppression = new JButton("Supprimer fruit");

        listeFruits = new JComboBox<>();

        JPanel panelN = new JPanel(new FlowLayout());
        panelN.add(inc);
        panelN.add(listeFruits);
        panelN.add(creerFruit);
        panelN.add(bouton_suppression);
        panelN.add(deconnexion);
        add(panelN, BorderLayout.NORTH);

        add(dec, BorderLayout.SOUTH);

        java.awt.Dimension tailleBouton = new java.awt.Dimension(180, 45);
        b1.setPreferredSize(tailleBouton);
        b2.setPreferredSize(tailleBouton);

        JPanel panelBoutons = new JPanel(new java.awt.GridLayout(2, 1, 5, 15));
        panelBoutons.add(b1);
        panelBoutons.add(b2);

        JPanel panelTexte = new JPanel(new BorderLayout());
        panelTexte.add(new javax.swing.JScrollPane(affichenb), BorderLayout.CENTER);

        JPanel panelCentre = new JPanel(new BorderLayout());
        panelCentre.add(panelTexte, BorderLayout.CENTER);
        panelCentre.add(panelBoutons, BorderLayout.EAST);

        add(panelCentre, BorderLayout.CENTER);

        inc.setName("Plus");
        dec.setName("Minus");
        affichenb.setName("Affichage");
        listeFruits.setName("Fruit");

        b1.setName("Boycott");
        b2.setName("ModifierCapacite");
        creerFruit.setName("CreerFruit");
        deconnexion.setName("Deconnexion");
        bouton_suppression.setName("Supprimer");

        listeFruits.setRenderer((list, value, index, isSelected, cellHasFocus) -> {
            javax.swing.JLabel lbl = new javax.swing.JLabel();
            if (value != null) {
                lbl.setText(formatFruit(value));
            }
            return lbl;
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 600);
        setVisible(true);

        affichenb.setLineWrap(true);
        affichenb.setWrapStyleWord(true);
        affichenb.setEditable(false);
    }

    private String formatFruit(Fruit f) {
        if (f == null) return "";
        return f.getClass().getSimpleName()
                + " (" + f.getOrigine() + ") - " + f.getPrix() + " euros";
    }

    public JButton getInc() { return inc; }
    public JButton getDec() { return dec; }
    public JButton getBoycott() { return b1; }
    public JButton getModifierCapacite() { return b2; }
    public JButton getCreerFruit() { return creerFruit; }
    public JComboBox<Fruit> getListeAdd() { return listeFruits; }
    public JTextArea getAffiche() { return affichenb; }
    public JButton getdeconnexion() {return deconnexion;}

    public void addListeFruits(Fruit f) {
        listeFruits.addItem(f);
    }
    public void Boycott(String origine){
        int i = 0;
        while (i<listeFruits.getItemCount()){
            if (listeFruits.getItemAt(i).getOrigine().equals(origine)){
                listeFruits.removeItemAt(i);
            }
            else{
                i++;
            }
        }
    }

    public void supprimerFruit(Fruit f) throws ListeVideException
    {
        if(listeFruits.getItemCount()!=0){
        for(int i=0 ; i<listeFruits.getItemCount() ; i++)
        {
            if(listeFruits.getItemAt(i).equals(f))
            {
                listeFruits.removeItemAt(i);
                break;
            }
        }
        }else{
            throw new ListeVideException();
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Panier p = (Panier) evt.getSource();

        StringBuilder sb = new StringBuilder();

        if (p.estVide()) {
            sb.append("Panier de 0 fruits\n");
        } else {
            sb.append("Panier de ")
              .append(p.getFruits().size())
              .append(" fruits : ")
              .append(p.getPrice())
              .append(" euros\n");
        }

        for (int i = 0; i < listeFruits.getItemCount(); i++) {
            Fruit f = listeFruits.getItemAt(i);
            int nb = p.nbFruits(f);
            sb.append(nb).append(" ").append(formatFruit(f)).append("\n");
        }

        affichenb.setText(sb.toString());
    }
    public void resetAffichage() {
    affichenb.setText("Panier de 0 fruits\n");
    listeFruits.removeAllItems();
}


    @Override
    public void addControleur(Controleur c) {
        inc.addActionListener(c);
        dec.addActionListener(c);
        b1.addActionListener(c);
        b2.addActionListener(c);
        creerFruit.addActionListener(c);
        deconnexion.addActionListener(c);
        bouton_suppression.addActionListener(c);
    }
}
