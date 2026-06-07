/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.panier.Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wg203076
 */
public class GestionUtilisateurs {

    private List<Utilisateur> users = new ArrayList<>();
    private final File fichierUsers = new File("users.txt");

    public GestionUtilisateurs() {
    
        chargerDepuisFichier();

        
        if (!existe("admin")) {
            users.add(new Utilisateur("admin", "admin"));
            sauvegarderDansFichier();
        }
    }

    public boolean existe(String login) {
        return users.stream().anyMatch(u -> u.getLogin().equals(login));
    }

    public boolean ajouterUtilisateur(String login, String mdp) {
        if (login == null || login.isEmpty()) return false;
        if (mdp == null || mdp.isEmpty()) return false;
        if (existe(login)) return false;

        users.add(new Utilisateur(login, mdp));
        sauvegarderDansFichier();  
        return true;
    }

    public boolean verifierConnexion(String login, String mdp) {
        return users.stream().anyMatch(u ->
                u.getLogin().equals(login) && u.getMdp().equals(mdp));
    }

    

    private void chargerDepuisFichier() {
        if (!fichierUsers.exists()) {
            return;  
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fichierUsers))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                if (ligne.trim().isEmpty()) continue;
                String[] parts = ligne.split(";");
                if (parts.length >= 2) {
                    String login = parts[0];
                    String mdp = parts[1];
                    users.add(new Utilisateur(login, mdp));
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement des utilisateurs : " + e.getMessage());
        }
    }

    private void sauvegarderDansFichier() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fichierUsers))) {
            for (Utilisateur u : users) {
                pw.println(u.getLogin() + ";" + u.getMdp());
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de l'enregistrement des utilisateurs : " + e.getMessage());
        }
    }
}
