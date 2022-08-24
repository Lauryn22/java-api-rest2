
package fr.m2i.javaapirest;

import java.util.ArrayList;
import java.util.List;

public class AnnuaireDAO {
    
     private static List<Personne> data = new ArrayList<>();
    static {
    data.add(new Personne(1, "Bila", "Laurent"));
    data.add(new Personne(2, "Jean", "Dupont"));
    }
    
   public List<Personne> listAll() {
       return new ArrayList<Personne>(data);
   }
   
   public int add(Personne personne) {
       int newId = data.size() + 1;
       personne.setId(newId);
       data.add(personne);
       
       return newId;
   }
   
   public Personne get(int id) {
       Personne personneToFind = new Personne(id);
       int index = data.indexOf(personneToFind);
       if (index >= 0) {
           return data.get(index);
       }
       return null;
   }
   
   public boolean update(Personne personne) {
       int index = data.indexOf(personne);
       if (index >= 0) {
           data.set(index, personne);
           return true;
       }
       return false;
   }
   
   public boolean delete(int id){
       Personne personneToFind = new Personne(id);
       int index = data.indexOf(personneToFind);
       if (index >= 0) {
           data.remove(index);
           return true;
       }
       return false;
   }
        
    
}
