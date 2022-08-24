
package fr.m2i.javaapirest;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Personne {
    
    private int id;
    private String nom;
    private String prenom;
    
    public Personne(int id) {
        this.id = id;
    }
    
    public Personne(int id, String nom ,String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public Personne () {
        
    }
        
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
        
        
    
}
