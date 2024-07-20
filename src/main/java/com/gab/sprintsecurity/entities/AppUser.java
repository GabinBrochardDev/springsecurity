package com.gab.sprintsecurity.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "users")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(unique = true, nullable = false)
    private String username;
    private String password;
    private String prenom;
    private String nom;
    private String role;
    private Date dateCreation;

    public int getIdUser() {
        return idUser;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getRole() {
        return role;
    }


    public Date getDateCreation() {
        return dateCreation;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
