
package lst.tpjava.services;


import lst.tpjava.models.Departement;
import lst.tpjava.models.Enseignant;
import lst.tpjava.models.Filiere;
import lst.tpjava.services.DB;

import java.util.ArrayList;

public class FiliereServices {

    public static Filiere addFiliere(int id,String intitule, Enseignant chef, Departement dept) {
        Filiere filiere =new Filiere();
        filiere.setId(DB.getFilIDId());
        filiere.setIntitule(intitule);

        filiere.setChef(chef);
        filiere.setDept(dept);

        DB.filieres.add(filiere);

        return  filiere;
    }

    public static Filiere updateFiliere(int id,String intitule, Enseignant chef, Departement dept){
        for(Filiere filiere :DB.filieres)
        {
            if(filiere.getId()==id)
            {
                filiere.setIntitule(intitule);

                filiere.setChef(chef);
                filiere.setDept(dept);
                return filiere;
            }
        }
        return  new Filiere();
    }
    public static ArrayList<Filiere> deleteFiliereById(int id){
        DB.filieres.remove(getFiliereById(id));
        return  DB.filieres;
    }

    public static Filiere getFiliereById(int id){
        for (Filiere filiere : DB.filieres) {
            if (filiere.getId() == id) {
                return  filiere;
            }
        }
        return  new Filiere();
    }

    public static ArrayList<Filiere> getAllFiliere(){
        return  DB.filieres;
    }
}


