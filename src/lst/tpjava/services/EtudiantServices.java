
package lst.tpjava.services;

import lst.tpjava.models.Enseignant;
import lst.tpjava.models.Etudiant;
import lst.tpjava.models.Filiere;
import lst.tpjava.models.Module;

import java.util.ArrayList;

public class EtudiantServices {

    public static Etudiant addEtd(int id,String nom, String prenom, String email, int apogee, Filiere filiere){

        for ( Etudiant  etudiant: DB.etudiants) {
            if ( etudiant.getId() == id) {
                etudiant.setNom(nom);
                etudiant.setPrenom(prenom);
                etudiant.setEmail(email);
                etudiant.setApogee(apogee);
                etudiant.setFiliere(filiere);

            }
        }
        return  new Etudiant();
    }

    public static Etudiant updateEtd(int id,String nom, String prenom, String email, int apogee, Filiere filiere){
        for ( Etudiant  etudiant: DB.etudiants) {
            if ( etudiant.getId() == id) {
            }
        }

        return  new Etudiant();
    }
    public static ArrayList<Etudiant> deleteEtdById(int id){
        DB.etudiants.remove(getEtdById(id));
        return DB.etudiants ;
    }



    public static Etudiant getEtdById(int id){
        for ( Etudiant  etudiant: DB.etudiants) {
            if (etudiant.getId() == id) return  etudiant ;
        }




        return  new Etudiant();
    }

    public static ArrayList<Etudiant> getAllEtd(){
        return  DB.etudiants;
    }

}



