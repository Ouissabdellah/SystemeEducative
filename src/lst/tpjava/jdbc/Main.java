package lst.tpjava.jdbc;

import lst.tpjava.controller.*;
import lst.tpjava.models.Enseignant;
import lst.tpjava.models.Etudiant;
import lst.tpjava.services.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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


            System.out.println(" Pour gérer les départements taper--: a");
            System.out.println(" Pour gérer les filières taper------: b");
            System.out.println(" Pour gérer les enseignants---------: c");
            System.out.println(" Pour gérer les modules-------------: d");
            System.out.println(" Pour gérer les étudiants-----------: e");
            System.out.println(" Pour sortir -----------------------: s");

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

            String dburl = "jdbc:mysql://localhost:3306/getionDepartement";
            String username = "username";
            String password = "passeword";
            try {
                Connection cx = DriverManager.getConnection(dburl, username, password);
                System.out.println("connecte avec succer");
            } catch (SQLException e) {
                System.out.println("une ereur se produisent");
                e.printStackTrace();
            }}



}









