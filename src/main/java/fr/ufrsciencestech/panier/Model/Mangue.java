/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.Model;

/**
 *
 * @author zb783864
*/


public class Mangue extends FruitSimple {

    public Mangue() {
        this.prix_kilo = 2.0;
        this.origine = "Brésil";
    }

    public Mangue(double price, String country) {
        initAttributes(price, country);
        if (country == null || country.equals(""))
            this.origine = "Brésil";
    }

    @Override
    public boolean isSeedless() {
        return false;
    }
}

