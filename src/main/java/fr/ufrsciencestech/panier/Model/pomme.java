/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.Model;

/**
 *
 * @author zb783864
 */


public class pomme extends FruitSimple {
    public pomme() {
        this.prix_kilo = 1.0;
        this.origine = "France";
    }


    public pomme(double prix, String origine) {
        initAttributes(prix, origine);
        if(origine.equals(""))
            this.origine="France";  //France par défaut
    }

    @Override
    public boolean isSeedless() {
        return false; 
    }
}
