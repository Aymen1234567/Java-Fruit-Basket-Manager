/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.Model;

/**
 *
 * @author ab661697
 */
public class ListeVideException extends Exception{
     public ListeVideException()
    {
	super("Impossible de supprimer un fruit dans une liste qui est vide !");
    }
}
