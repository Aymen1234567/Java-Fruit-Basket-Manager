/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.Model;

/**
 *
 * @author zb783864
 */


public class Kiwi extends FruitSimple {

    public Kiwi() {
        this.prix_kilo = 1.2;
        this.origine = "France";
    }

    public Kiwi(double price, String country) {
        initAttributes(price, country);
        if (country == null || country.equals(""))
            this.origine = "France";
    }

    @Override
    public boolean isSeedless() {
        return false;
    }
}

