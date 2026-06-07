package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.panier.Model.GestionUtilisateurs;
import fr.ufrsciencestech.panier.Controler.ControleurAuth;
import fr.ufrsciencestech.panier.View.VueConnexion;

/*
//pour springIoC :
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
*/

/**
 *
 * @author wg203076
 */
public class TestMVC {
    /*POUR SPRING IoC
    private VueGraphique vueg;  //VueGraphique : interface qu'implémentent VueGraphiqueSimple, VueGraphiqueSimpleAWT et VueGraphiqueListe
    private Controleur cs;  //VueGraphique : classe abstraite qu'implémentent ControleurSimple et ControleurListe
    
    public VueGraphique getVueg() {  //pour java bean
        return vueg; 
    }
    public void setVueg(VueGraphique vueg) {
        this.vueg = vueg; 
    }
    
    public Controleur getCs() {  //pour java bean
        return cs; 
    }
    public void setCs(Controleur cs) {
        this.cs = cs; 
    }*/

    public static void main(String[] args){
        GestionUtilisateurs gest = new GestionUtilisateurs();
        VueConnexion vue = new VueConnexion();
        ControleurAuth ca = new ControleurAuth(gest, vue);
    }
}
