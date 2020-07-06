package com.example.dmp.User;

public class Patient {
    private int id;
    private String prenom;
    private String nom;
    private String password;

    public Patient(){}


    public Patient(String prenom, String nom, String password){
        this.prenom = prenom;
        this.nom = nom;
        this.password = password;
    }

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

    @Override
    public String toString() {
        return "Patient{" +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", password ='" + password + '\'' +
                '}';
    }
}
