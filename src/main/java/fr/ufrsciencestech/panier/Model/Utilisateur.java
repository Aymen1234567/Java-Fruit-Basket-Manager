/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.Model;

/**
 *
 * @author wg203076
 */
public class Utilisateur {
    private String login;
    private String mdp;

    public Utilisateur(String login, String mdp) {
        this.login = login;
        this.mdp = mdp;
    }

    public String getLogin() {
        return login;
    }

    public String getMdp() {
        return mdp;
    }
}
