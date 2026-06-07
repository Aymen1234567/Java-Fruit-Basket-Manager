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
public class Cerise extends FruitSimple{
    
    public Cerise() 
    {
        this.origine="France";
        this.prix_kilo = 1.0;
    }
    
    public Cerise(double price, String country) 
    {
        initAttributes(price, country);
        if(country.equals(""))
            this.origine="France";   
    }

    @Override
    public boolean isSeedless() {
        return false;
    }
}
