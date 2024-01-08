package lst.tpjava.controller;

import lst.tpjava.Main;
import lst.tpjava.models.Filiere;
import lst.tpjava.models.Enseignant;
import lst.tpjava.services.DB;
import lst.tpjava.services.DepartementServices;
import lst.tpjava.services.EnseignantServices;
import lst.tpjava.services.FiliereServices;


public class FiliereController {
    public static void showMenu(){
        System.out.println("-------------------------[ Filiere]---------------------------");


        System.out.println("1: Pour ajouter un Filiere");
        System.out.println("2: Pour afficher les Filiere ");
        System.out.println("3: Pour modifier un Filiere");
        System.out.println("4: Pour supprimer un Filiere");
        System.out.println("0: Pour retourner au mennu principal");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createFiliere();
                break;
            case 2:
                showFiliere();
                break;
            case 3:
                editFiliere();
                break;
            case 4:
                destroyFiliere();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showFiliere(){
        for (Filiere  filieres: DB.filieres) {
            System.out.print(" | intitule : " + filieres .getIntitule());

            if (! Main.isNull(filieres.getChef())) {
                System.out.print(" | dept : " + filieres.getDept()+ " " + filieres.getModules());
            }
            System.out.println(" ");
        }

    }
    public static void createFiliere(){
        int id = Main.getIntInput("Sélecionnez une filieres par id pour Ajouter  filiere:");

        String intitule = Main.getStringInput("Sélecionnez filieres intitule pour ajouter filier:");
        DepartementsController.showDepartements();
        String chef = Main.getStringInput("Sélecionnez chef enseignant pour ajouter filiere:");
        int idDept= Main.getIntInput("Sélecionnez departement id :");

        FiliereServices.addFiliere(id,intitule,EnseignantServices.getEnsById(id),DepartementServices.getDeptById(idDept));

        showFiliere();
        showMenu();

    }

    public static void editFiliere(){
        showFiliere();

        int id = Main.getIntInput("Sélecionnez une filieres par id pour Ajouter :");

        String intitule = Main.getStringInput("Sélecionnez filieres intitule pour ajouti:");
        DepartementsController.showDepartements();
        String chef =Main.getStringInput("Sélecionnez enseinent pour ajouti:");

        int idDept= Main.getIntInput("Sélecionnez departement id :");



        FiliereServices.updateFiliere(id,intitule, EnseignantServices.getEnsById(id),DepartementServices.getDeptById(idDept));

        showFiliere();
        showMenu();
    }
    public static void destroyFiliere(){
        showFiliere();
        int id = Main.getIntInput("Sélecionnez un enseignant par id pour supprimer :");
        FiliereServices.deleteFiliereById(id);
        showFiliere();

    }
}










