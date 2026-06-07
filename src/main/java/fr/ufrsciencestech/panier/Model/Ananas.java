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
public class Ananas extends FruitSimple{
    
    public Ananas() 
    {
        this.prix_kilo=2.0;
        this.origine="Bresil";
    }
    
    public Ananas(double price, String country) 
    {
        initAttributes(price, country);
	if(country.equals(""))
            this.origine="Bresil";  //Bresil par défaut
    }
    

    @Override
    public boolean isSeedless() {
        return true;
    }
}
