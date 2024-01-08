package lst.tpjava.controller;
import lst.tpjava.Main;
import lst.tpjava.models.Note;
import lst.tpjava.models.Etudiant;


import lst.tpjava.services.*;


public class EtudiantsController {
    public static void showMenu(){
        System.out.println("-------------------------[ Etudiant ]---------------------------");


        System.out.println("1: Pour ajouter un etudiant");
        System.out.println("2: Pour afficher les etudiants");
        System.out.println("3: Pour modifier un etudiant");
        System.out.println("4: Pour supprimer un etudiant");
        System.out.println("0: Pour retourner au menu principale");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createEtudiant();
                break;
            case 2:
                showEtudiant();
                break;
            case 3:
                editEtudiant();
                break;
            case 4:
                destroyEtudiant();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showEtudiant(){
        for (Etudiant etudiants : DB.etudiants ) {
            System.out.print("NOM : " + etudiants.getNom());
            System.out.print(" | prenom: " +etudiants. getPrenom());
            System.out.print(" | NOTE: " +etudiants. getNotes());

            if (! Main.isNull(etudiants.getApogee())) {
                System.out.print(" | filliere : " + etudiants.getApogee()+"  "+etudiants.getNom());
            }
            System.out.println(" ");
        }

    }
    public static void createEtudiant(){
        int id = Main.getIntInput("Sélecionnez un fillire par id pour Ajoutr :");
        String nom = Main.getStringInput("Entrez nom :");
        String prenom = Main.getStringInput("Entrez prenom :");
        String email = Main.getStringInput("Entrez email:");
        int apogee = Main.getIntInput("Entrez apogee :");
        FiliereController.showFiliere();
        int idFiliere= Main.getIntInput("Sélecionnez un filliere id :");


        EtudiantServices.addEtd( id,nom,prenom,email,apogee, FiliereServices.getFiliereById(idFiliere));

        showEtudiant();
        showMenu();


    }

    public static void editEtudiant(){
        showEtudiant();
        int id = Main.getIntInput("Sélecionnez un fillire par id pour modifier :");
        String nom = Main.getStringInput("Entrez nom :");
        String prenom = Main.getStringInput("Entrez prenom :");
        String email = Main.getStringInput("Entrez email:");
        int apogee = Main.getIntInput("Entrez apogee :");
        FiliereController.showFiliere();
        int idFiliere= Main.getIntInput("Sélecionnez un filliere id :");

        EtudiantServices.updateEtd( id,nom,prenom,email,apogee, FiliereServices.getFiliereById(idFiliere));

        showEtudiant();
        showMenu();

    }
            public static void destroyEtudiant(){
        showEtudiant();
        int Apogee = Main.getIntInput("Sélecionnez un etudiant par id pour supprimer :");
        EtudiantServices. deleteEtdById(Apogee);
        showEtudiant();

    }


    }


