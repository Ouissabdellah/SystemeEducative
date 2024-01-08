package lst.tpjava.controller;

import lst.tpjava.Main;
import lst.tpjava.models.Departement;
import lst.tpjava.models.Enseignant;
import lst.tpjava.services.DB;
import lst.tpjava.services.DepartementServices;

import lst.tpjava.controller.DepartementsController;
import lst.tpjava.services.EnseignantServices;


public class EnseignantController {

    public static void showMenu(){
        System.out.println("-------------------------[ Enseignant]---------------------------");


        System.out.println("1: Pour ajouter un Enseingnant");
        System.out.println("2: Pour afficher les Enseingnant ");
        System.out.println("3: Pour modifier un Enseingnant");
        System.out.println("4: Pour supprimer un Enseingnant");
        System.out.println("0: Pour retourner au mennu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createEnseignant();
                break;
            case 2:
                showEnseignant();
                break;
            case 3:
                editEnseignant();
                break;
            case 4:
                destroyEnseignant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showEnseignant(){
        for (Enseignant enseignants : DB.enseignants) {
            System.out.print("Id : " + enseignants.getId());
            System.out.print(" | Email : " + enseignants.getEmail());
            if (! Main.isNull(enseignants.getGrade())) {
                System.out.print(" | Grad : " + enseignants.getGrade());
            }
            System.out.println(" ");
        }

    }
    public static void createEnseignant(){
        int id = Main.getIntInput("Sélecionnez un ensnaint par id pour Ajouter :");
        String nom = Main.getStringInput("Sélecionnez un ensnaint par nom pour ajouter:");
        String prenom = Main.getStringInput("Sélecionnez enseignnt prenom pour ajouti:");
        String email= Main.getStringInput("Sélecionnez enseignnt email pour ajouter:");


        String grade= Main.getStringInput("Entrez le grade :");
        DepartementsController.showDepartements();
        int idDept= Main.getIntInput("Sélecionnez un departement id :");

        EnseignantServices.addEns(id,nom,prenom,grade,email,DepartementServices.getDeptById(idDept));

        showEnseignant();
        showMenu();


    }

    public static void editEnseignant(){
        showEnseignant();
        int id = Main.getIntInput("Sélecionnez un ensnaint par id pour modifier :");
        String nom = Main.getStringInput("Sélecionnez un ensnaint par nom pour modifier :");
        String prenom = Main.getStringInput("Sélecionnez enseignnt prenom pour modifier :");
        String email= Main.getStringInput("Sélecionnez enseignnt email pour modifier :");


        String grade= Main.getStringInput("Entrez le grade :");
        DepartementsController.showDepartements();
        int idDept= Main.getIntInput("Sélecionnez un departement id :");

        EnseignantServices.updateEns(id,grade,nom,prenom,email,DepartementServices.getDeptById(idDept));

        showEnseignant();
        showMenu();
    }
    public static void destroyEnseignant(){
        showEnseignant();
        int id = Main.getIntInput("Sélecionnez un enseignant par id pour supprimer :");
        EnseignantServices.deleteEnsById(id);
        showEnseignant();

    }
}






