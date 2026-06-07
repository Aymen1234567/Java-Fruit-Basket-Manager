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
public interface Fruit {
    public boolean isSeedless();
    public double getPrix();
    public String getOrigine();
    @Override
    public String toString();
    @Override
    public boolean equals(Object o);

    
}
