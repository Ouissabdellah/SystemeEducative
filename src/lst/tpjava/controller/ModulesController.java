package lst.tpjava.controller;

import lst.tpjava.Main;
import lst.tpjava.models.Enseignant;
import lst.tpjava.models.Module;
import lst.tpjava.services.*;


public class ModulesController {


    public static void showMenu(){
        System.out.println("-------------------------[Modules]---------------------------");


        System.out.println("1: Pour ajouter un Module");
        System.out.println("2: Pour afficher les modules");
        System.out.println("3: Pour modifier un modules");
        System.out.println("4: Pour supprimer un module");
        System.out.println("4: Pour returner un module");

        //"Veuillez sélectionner une option : ")
        int option = Main.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createModule();
                break;
            case 2:
                showModule();
                break;
            case 3:
                editModule();
                break;
            case 4:
                destroyModule();
                break;
            default:
                Main.showPrincipalMenu();
        }
    }
    public static void showModule(){
        for (Module modules: DB.modules) {
            System.out.print("Id : " + modules.getId());
            System.out.print(" | intitude: " + modules.getIntitule());
            System.out.print(" | filiere: " + modules.getFiliere());
            if (! Main.isNull(modules.getChef())) {
                System.out.print(" | Chef : " + modules.getChef().getNom() + " " + modules.getChef().getPrenom());
            }
            System.out.println(" ");
        }

    }
    public static void createModule(){
        int id = Main.getIntInput("Sélecionnez un module par id pour modifier :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantController.showEnseignant();
        int idEns= Main.getIntInput("Sélecionnez un ensiengant id :");
        FiliereController.showFiliere();
        int idFiliere= Main.getIntInput("Sélecionnez un filliere id :");


        ModuleServices. addModule(id,intitule,EnseignantServices.getEnsById(id),FiliereServices.getFiliereById(idFiliere));

        showModule();
        showMenu();


    }

    public static void editModule() {
        showModule();
        int id = Main.getIntInput("Sélecionnez un module par id pour modifier :");
        String intitule = Main.getStringInput("Entrez l'intitulé :");
        EnseignantController.showEnseignant();
        int idEns= Main.getIntInput("Sélecionnez un ensiengant id :");
        FiliereController.showFiliere();
        int idFiliere= Main.getIntInput("Sélecionnez un filliere id :");



        ModuleServices.updateModule(id,intitule,EnseignantServices.getEnsById(id),FiliereServices.getFiliereById(idFiliere));

        showModule();
        showMenu();
    }
    public static void destroyModule(){
        showModule();
        int id = Main.getIntInput("Sélecionnez un Module par id pour supprimer :");
        ModuleServices.deleteModuleById(id);
        showModule();

    }






    }