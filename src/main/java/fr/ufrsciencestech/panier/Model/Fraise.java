/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.Model;

/**
 *
 * @author celine
 */
public class Fraise extends FruitSimple{
    
    public Fraise() 
    {
        this.origine="Espagne";
        this.prix_kilo = 1.5;
    }
    
    public Fraise(double price, String country) 
    {
        initAttributes(price, country);
        if(country.equals(""))
            this.origine="Espagne";  //Espagne par défaut
    }

    @Override
    public boolean isSeedless() {
        return true;
    }
}
