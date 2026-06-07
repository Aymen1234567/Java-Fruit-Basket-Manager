/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier.Model;

/**
 *
 * @author roudet
 */
public class Orange extends FruitSimple {
	
    public Orange() 
    {
        this.prix_kilo = 0.5;
        this.origine="Espagne";
    }
    
    public Orange(double price, String country) 
    {
        initAttributes(price, country);
	if(country.equals(""))
            this.origine="Espagne";  //Espagne par défaut  
    }

    @Override
    public boolean isSeedless() {
        return false;
    }
}
