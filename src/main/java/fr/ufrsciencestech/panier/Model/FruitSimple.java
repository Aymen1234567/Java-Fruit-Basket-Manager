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
public abstract class FruitSimple implements Fruit {
    protected double prix_kilo;
    protected String origine;
    
    
    
    @Override
    public double getPrix(){
	return prix_kilo;
    }
    @Override
    public String getOrigine(){
	return origine;
    }
    
    public void setPrix(double price){
	this.prix_kilo=price;
    }
 
    public void setOrigine(String country){
	this.origine=country;
    }
    
    protected void initAttributes(double price, String country){
        if(price < 0){
            this.prix_kilo = -price;  //ou = 0
            //ou throw new Exception();
	} 
	else
            this.prix_kilo = price;
 
        this.origine = country;
    }
    
    @Override
    public boolean equals(Object o){
        if(o != null && getClass() == o.getClass()){
            FruitSimple fs = (FruitSimple) o;
            return (prix_kilo == fs.prix_kilo && origine.equals(fs.origine));
        }
        return false;
    }
  
    @Override
    public String toString(){
        return getClass().getSimpleName() ;
    }

    @Override
    public abstract boolean isSeedless();
    
}
