package lst.tpjava.services;

import lst.tpjava.models.Departement;
import lst.tpjava.models.Enseignant;
import lst.tpjava.services.DB;
import java.util.ArrayList;

public class EnseignantServices {

    public static Enseignant addEns(int id, String nom, String prenom, String email, String grade, Departement dept){

        Enseignant    enseignant = new Enseignant ();
        enseignant.setNom(nom);
        enseignant.setPrenom(prenom);
        enseignant.setEmail(email);
        enseignant.setDept(dept);
        enseignant.setId(DB.getEnsId());
        DB.enseignants.add(enseignant);


        return  new Enseignant();
    }

    public static Enseignant updateEns(int id, String nom, String prenom, String email, String grade, Departement dept){

        for ( Enseignant  enseignant : DB.enseignants) {
            if ( enseignant.getId() == id) {
                enseignant.setNom(nom);
                enseignant.setPrenom(prenom);
                enseignant.setEmail(email);
                enseignant.setDept(dept);

            }
        }

        return  new Enseignant();
    }
    public static ArrayList<Enseignant> deleteEnsById(int id){

        DB.enseignants.remove(getEnsById(id));
        return  DB.enseignants;

            }
    public static Enseignant getEnsById(int id){
        for ( Enseignant  enseignant : DB.enseignants) {
            if (enseignant .getId() == id) return  enseignant ;
        }

        return  new Enseignant();

            }
    public static ArrayList<Enseignant> getAllEns(){
        return  DB.enseignants;

            }
        }