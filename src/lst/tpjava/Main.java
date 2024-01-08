

package lst.tpjava;

import lst.tpjava.controller.*;
import lst.tpjava.controller.EnseignantController;
import lst.tpjava.models.Enseignant;
import lst.tpjava.models.Etudiant;
import lst.tpjava.services.DB;
import java.util.Scanner;

public class Main {

    public static boolean isNull(Object ob) {
        return ob == null;
    }

    public static int getIntInput(String... msg) {
        Scanner scan = new Scanner(System.in);
        String message = "Entrez un nombre entier : ";
        if (msg.length > 0)
            message = msg[0];
        System.out.print(message);


        // This method reads the number provided using keyboard
        int num = scan.nextInt();

        // Closing Scanner after the use
        //  scan.close();
        return num;
    }

    public static String getStringInput(String... msg) {
        Scanner scan = new Scanner(System.in);
        String message = "Entrez un texte : ";
        if (msg.length > 0)
            message = msg[0];
        System.out.print(message);

        // This method reads the number provided using keyboard
        String str = scan.nextLine();

        // Closing Scanner after the use
        //  scan.close();
        return str;
    }

    public static void showPrincipalMenu() {
        System.out.println("-------------------------[ Bienvenu ]---------------------------");


        System.out.println(" Pour gérer les départements clicker sur--: a");
        System.out.println(" Pour gérer les filières clicker sur-----: b");
        System.out.println(" Pour gérer les enseignants clicker sur------: c");
        System.out.println(" Pour gérer les modules  clicker sur----------: d");
        System.out.println(" Pour gérer les étudiants clicker sur---------: e");
        System.out.println(" Pour sortir -clicker sur------------------: s");

        //"Veuillez sélectionner une option : ")
        String option = getStringInput("Veuillez choisez une option : ");
        switch (option) {
            case "a":
                DepartementsController.showMenu();
                break;
            case "b":
                FiliereController.showMenu();
                break;
            case "c":

                EnseignantController.showMenu();
                break;
            case "d":
                ModulesController.showMenu();
                break;
            case "e":
                EtudiantsController.showMenu();
                break;
            default:
                // code block
        }


    }

    public static void main(String[] args) {

        Enseignant enseignant = new Enseignant();
        enseignant.setNom("said");
        enseignant.setPrenom("ait mahdi");
        enseignant.setEmail("tstgmail");
        enseignant.setGrade("ing");
        enseignant.setId(DB.getEnsId());
        DB.enseignants.add(enseignant);
        showPrincipalMenu();

Etudiant etudiant =new Etudiant();
        etudiant.setNom("abdellah");
        etudiant.setPrenom("ouiss");
        etudiant.setEmail("abbdellah ouiss");
        etudiant.setApogee(123);
        etudiant.setId(1);
        DB.etudiants.add(etudiant);
    }

}

