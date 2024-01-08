
package lst.tpjava.services;

import lst.tpjava.models.Departement;
import lst.tpjava.models.Enseignant;
import lst.tpjava.models.Filiere;
import lst.tpjava.models.Module;

import java.util.ArrayList;

public class ModuleServices {

    public static Module addModule(int id , String intitule, Enseignant chef,  Filiere filiere) {


        Module module= new Module();
        module.setIntitule(intitule);
        module.setChef(chef);
        module.setFiliere(filiere);
        module.setId(id);

        DB.modules.add(module);
        return  new Module();
    }

    public static Module updateModule(int id , String intitule, Enseignant chef,  Filiere filiere){

        for (Module module  : DB.modules) {
            if ( module.getId() == id) {
                module.setIntitule(intitule);
                module.setChef(chef);
                module.setFiliere(filiere);

            }
        }
        return  new Module();
    }
    public static ArrayList<Module> deleteModuleById(int id){


        DB.modules.remove(getModuleById(id));

        return  DB.modules;
    }

    public static Module getModuleById(int id){

        for ( Module module : DB.modules) {
            if (module.getId() == id) return  module ;
        }

        return  new Module();
    }

    public static ArrayList<Module> getAllModule(){
        return  DB.modules;
    }
}

