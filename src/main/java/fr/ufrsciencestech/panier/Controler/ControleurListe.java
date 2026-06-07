package fr.ufrsciencestech.panier.Controler;

import fr.ufrsciencestech.panier.Model.*;
import fr.ufrsciencestech.panier.View.*;
import java.awt.Frame;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class ControleurListe extends Controleur {

    private VueGraphiqueListe vg;
    private ControleurAuth auth;

public void setAuth(ControleurAuth auth) {
    this.auth = auth;
}

    public void setVue(VueGraphique vg) {
        this.vg = (VueGraphiqueListe) vg;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = ((Component) e.getSource()).getName();

        // Bouton "+"
        if (name.equals("Plus")) {
            try {
                p.add((Fruit) vg.getListeAdd().getSelectedItem());
            } catch (PanierPleinException ex) {
                JOptionPane.showMessageDialog(
                        vg,
                        ex.getMessage(),
                        "Panier plein",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }

        // Bouton "-"
        else if (name.equals("Minus")) {
            try {
                p.remove();
            } catch (PanierVideException ex) {
                JOptionPane.showMessageDialog(
                        vg,
                        ex.getMessage(),
                        "Panier vide",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }

        // Bouton "Modifier capacité"
        else if (name.equals("ModifierCapacite")) {

            VueModifierCapacite dialog = creerDialogModifierCapacite(vg, p.getContMax());

            dialog.getBtnValider().addActionListener(ev -> {
                int nouvelleCap = dialog.getNouvelleCapacite();
                try {
                    p.setContMax(nouvelleCap);
                    dialog.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            vg,
                            "Erreur : " + ex.getMessage(),
                            "Erreur capacité",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            });

            dialog.setVisible(true);
        }


       
         else if (name.equals("CreerFruit")) {
            VueCreerFruit dialog = creerDialog(vg);
            boolean dejadedans = false;
            dialog.setVisible(true);

            if (!dialog.isValide()) {
                return;
            }

            String type = dialog.getTypeSelectionne();
            double prix = dialog.getPrixSaisi();
            String origine = dialog.getOrigineSelectionnee();
            Fruit nouveau = creerFruitDepuisChamps(type, prix, origine);
            if (nouveau != null) {
                for (int i =0;i<vg.getListeAdd().getItemCount();i++){
                    if (nouveau.equals(vg.getListeAdd().getItemAt(i))){
                        dejadedans = true;
                        break;
                    }
                }              
                if(!dejadedans){
                    vg.addListeFruits(nouveau);
                }
                else{
                    //erreur
                }
            }            


        }
        else if(name.equals(("Boycott"))){
            VueBoycott dialog = creerDialogBoycott(vg);

            dialog.setVisible(true);
            if(dialog.isValide()){
                vg.Boycott(dialog.getOrigineSelectionnee());
                p.boycottOrigin(dialog.getOrigineSelectionnee());
            }
        }
        //Bouton "Supprimer"
        else if(name.equals("Supprimer"))
        {
            VueSuppression dialog = new VueSuppression(vg);
            //vg.supp(f);
            dialog.getBoutonValider().addActionListener(ev -> 
            {
                try {
                vg.supprimerFruit(dialog.getSelectedFruit());
                 } catch (ListeVideException ex) {
                JOptionPane.showMessageDialog(
                        vg,
                        ex.getMessage(),
                        "Liste Vide",
                        JOptionPane.ERROR_MESSAGE
                );
            }
                p.supprimerFruit(dialog.getSelectedFruit());
               
            });
            dialog.setVisible(true);
        }
        else if (name.equals("Deconnexion")) {

    
            vg.resetAffichage(); 


            vg.setVisible(false);
            vg.dispose();


            if (auth != null) auth.retourConnexion();
        }

    }
    
    
protected VueBoycott creerDialogBoycott(Frame parent) {
    return new VueBoycott(parent);
}


    private Fruit creerFruitDepuisChamps(String type, double prix, String origine) {
        switch (type) {
            case "Orange": return new Orange(prix, origine);
            case "Banane": return new Banane(prix, origine);
            case "Pomme":  return new pomme(prix, origine);
            case "Kiwi":   return new Kiwi(prix, origine);
            case "Citron": return new Citron(prix, origine);
            case "Mangue": return new Mangue(prix, origine);
            case "Ananas": return new Ananas(prix, origine);
            case "Fraise": return new Fraise(prix, origine);
            case "Cerise": return new Cerise(prix, origine);
            default: return null;
        }
    }
protected VueCreerFruit creerDialog(VueGraphiqueListe parent) {
    return new VueCreerFruit(parent);
}
protected VueModifierCapacite creerDialogModifierCapacite(VueGraphiqueListe parent, int contMax) {
    return new VueModifierCapacite(parent, contMax);
}

}
