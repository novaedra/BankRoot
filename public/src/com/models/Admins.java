package com.models;

import org.joda.time.format.DateTimeFormat;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    private Timestamp created_at;
    private Timestamp updated_at;
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

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Admins setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
        return this;
    }



    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public Admins setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
        return this;
    }

    @Override
    public String getTableName() {
        this.tableName = "bradmin";
        return this.tableName;
    }
}
