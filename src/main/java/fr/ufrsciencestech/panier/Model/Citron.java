/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.Model;

/**
 *
 * @author zb783864
 */


public class Citron extends FruitSimple {

    public Citron() {
        this(0.8, "Senegal");
    }

    public Citron(double prix, String origine) {
        if (origine == null || origine.isEmpty())
            origine = "Senegal";
        initAttributes(prix, origine);
    }

    @Override
    public boolean isSeedless() {
        return false;
    }
}
