package com.gab.sprintsecurity.entities;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class RegisterDto {

    @NotEmpty
    private String prenom;

    @NotEmpty
    private String nom;

    @NotEmpty
    private String username;

    @Size(min = 6, message = "Le mot de passe doit être de minimum 6 caracteres")
    private String password;

    private String confirmPassword;

    public @NotEmpty String getPrenom() {
        return prenom;
    }

    public void setPrenom(@NotEmpty String prenom) {
        this.prenom = prenom;
    }

    public @NotEmpty String getNom() {
        return nom;
    }

    public void setNom(@NotEmpty String nom) {
        this.nom = nom;
    }

    public @NotEmpty String getUsername() {
        return username;
    }

    public void setUsername(@NotEmpty String username) {
        this.username = username;
    }

    public @Size(min = 6, message = "Le mot de passe doit être de minimum 6 caracteres") String getPassword() {
        return password;
    }

    public void setPassword(@Size(min = 6, message = "Le mot de passe doit être de minimum 6 caracteres") String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
