
package fr.m2i.javaapirest.tpuser.dao;

import fr.m2i.javaapirest.Personne;
import fr.m2i.javaapirest.tpuser.model.User;
import fr.m2i.javaapirest.tpuser.util.SessionHelper;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


public class UserDAO {
    
    private final EntityManager entityManager;
    
    public UserDAO() {
        this.entityManager = SessionHelper.getEntityManager();
     
      
    }
    

    public boolean create(User userToCreate) {

        if (userToCreate == null) {
            System.out.println("L'objet utilisateur ne peut pas être null");
            return false;
        }

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(userToCreate);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Create|All fields");
            System.out.println("Exception message : " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
            return false;
        }
        return true;
    }
    
 
    
}
