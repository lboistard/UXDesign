package com.example.dmp.User;

/**
 * Création d'un objet patient
 * @author Lucas
 */
public class User {

    private int id;
    private String prenom;
    private String nom;
    private String password;
    private String CPS;

    public User(){}

    //~-------------------------------------------------------
    //~ Constructor
    //~-------------------------------------------------------
    public User(String prenom, String nom, String password, String CPS){
        this.prenom = prenom;
        this.nom = nom;
        this.password = password;
        this.CPS = CPS;
    }

    //~-------------------------------------------------------
    //~ Getters and Setters
    //~-------------------------------------------------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCPS(){
        return CPS;
    }

    public void setCPS(String CPS){
        this.CPS = CPS;
    }
    //~-------------------------------------------------------
    //~ toString()
    //~-------------------------------------------------------
    @Override
    public String toString() {
        return "User{" +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", password ='" + password + '\'' +
                ", CPS = '" + CPS + '\'' +
                '}';
    }
}
