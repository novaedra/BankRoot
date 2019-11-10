package com.models;

public class Admins extends BaseModelORM {
    private Integer id;
    private String nom;
    private String prenom;
    private String password;
    private String twoFactorKey;
    private String birthday;
    private String mail;
    private String telephone;
    private String role;
    private String tableName;

    public String getNom() {
        return nom;
    }

    public Admins setNom(String nom) {

        this.nom = nom;

        return this;
    }


    public String getPrenom() {
        return prenom;
    }

    public Admins setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }


    public String getPassword() {
        return this.password;
    }

    public Admins setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getTwoFactorKey() {
        return twoFactorKey;
    }

    public Admins setTwoFactorKey(String twoFactorKey) {
        this.twoFactorKey = twoFactorKey;
        return this;
    }


    public String getBirthday() {
        return birthday;
    }

    public Admins setBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }


    public String getMail() {
        return this.mail;
    }

    public Admins setMail(String mail) {
        this.mail = mail;
        return this;
    }


    public String getTelephone() {
        return telephone;
    }

    public Admins setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }


    public String getRole() {
        return role;
    }

    public Admins setRole(String supadmin) {
        this.role = supadmin;
        return this;
    }

    @Override
    public String getTableName() {
        this.tableName = "bradmin";
        return this.tableName;
    }
}
