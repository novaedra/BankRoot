package com.models;

public class Conditions extends BaseModelORM {

    private Integer id;
    private String nom;
    private String argument;
    private String operateur;
    private String valeur;
    private Integer produit_has_condition;

    private String tableName;

    public String getNom() {
        return nom;
    }

    public Conditions setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getArgument() {
        return argument;
    }

    public Conditions setArgument(String argument) {
        this.argument = argument;
        return this;
    }

    public String getOperateur() {
        return operateur;
    }

    public Conditions setOperateur(String operateur) {
        this.operateur = operateur;
        return this;
    }

    public String getValeur() {
        return valeur;
    }

    public Conditions setValeur(String valeur) {
        this.valeur = valeur;
        return this;
    }

    public Integer getProduit_has_condition() {
        return produit_has_condition;
    }

    public Conditions setProduit_has_condition(Integer produit_has_condition) {
        this.produit_has_condition = produit_has_condition;
        return this;
    }



    @Override
    public String getTableName() {
        this.tableName = "brconditions";
        return this.tableName;
    }

}
