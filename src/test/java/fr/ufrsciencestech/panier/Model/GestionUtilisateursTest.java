/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author wg203076
 */
package fr.ufrsciencestech.panier.Model;

import org.junit.*;
import java.io.*;
import java.nio.file.*;
import static org.junit.Assert.*;

public class GestionUtilisateursTest {

    private static final File USERS_FILE = new File("users.txt");
    private static byte[] backupUsersFile = null;

    private GestionUtilisateurs gest;

    @BeforeClass
    public static void backupIfExists() throws Exception {
        if (USERS_FILE.exists()) {
            backupUsersFile = Files.readAllBytes(USERS_FILE.toPath());
        }
    }

    @AfterClass
    public static void restoreBackup() throws Exception {
        if (backupUsersFile != null) {
            Files.write(USERS_FILE.toPath(), backupUsersFile);
        } else {
            if (USERS_FILE.exists()) {
                USERS_FILE.delete();
            }
        }
    }

    @Before
    public void setUp() {
        if (USERS_FILE.exists()) {
            USERS_FILE.delete();
        }
        gest = new GestionUtilisateurs();
    }

    private String uniq(String base) {
        return base + "_" + System.currentTimeMillis() + "_" + (int)(Math.random() * 1_000_000);
    }

    @Test
    public void ajouterUtilisateur_valide_retourneTrue_et_creeCompte() {
        String login = uniq("alice");
        String mdp = "pass";

        assertTrue(gest.ajouterUtilisateur(login, mdp));
        assertTrue(gest.existe(login));
        assertTrue(gest.verifierConnexion(login, mdp));
    }

    @Test
    public void ajouterUtilisateur_doublon_refuse_et_ne_changePasMotDePasse() {
        String login = uniq("bob");

        assertTrue(gest.ajouterUtilisateur(login, "abcd"));
        assertFalse(gest.ajouterUtilisateur(login, "xyz"));

        assertTrue(gest.verifierConnexion(login, "abcd"));
        assertFalse(gest.verifierConnexion(login, "xyz"));
    }

    @Test
    public void verifierConnexion_valide_invalide_inconnu() {
        String login = uniq("user");
        assertTrue(gest.ajouterUtilisateur(login, "pass"));

        assertTrue(gest.verifierConnexion(login, "pass"));
        assertFalse(gest.verifierConnexion(login, "wrong"));
        assertFalse(gest.verifierConnexion(uniq("unknown"), "pass"));
    }

    @Test
    public void existe_avant_apres_ajout() {
        String login = uniq("zoe");

        assertFalse(gest.existe(login));
        assertTrue(gest.ajouterUtilisateur(login, "pw"));
        assertTrue(gest.existe(login));
        assertTrue(gest.verifierConnexion(login, "pw"));
    }

    @Test
    public void ajouterUtilisateur_loginNull_refuse() {
        assertFalse(gest.ajouterUtilisateur(null, "pass"));
    }

    @Test
    public void ajouterUtilisateur_mdpNull_refuse() {
        assertFalse(gest.ajouterUtilisateur(uniq("alice3"), null));
    }

    @Test
    public void ajouterUtilisateur_loginVide_refuse() {
        assertFalse(gest.ajouterUtilisateur("", "pass"));
    }

    @Test
    public void ajouterUtilisateur_mdpVide_refuse() {
        assertFalse(gest.ajouterUtilisateur(uniq("alice2"), ""));
    }

    @Test
    public void verifierConnexion_loginNull_ou_mdpNull_retourneFalse() {
        assertFalse(gest.verifierConnexion(null, "pass"));
        assertFalse(gest.verifierConnexion("user", null));
        assertFalse(gest.verifierConnexion(null, null));
    }
}

