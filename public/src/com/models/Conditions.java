package com.models;

public class Conditions extends BaseModelORM {
    private String nom;
    private String operateur;
    private String value;
    private String score;
    private String arguments;
    String tableName = "brconditions";

    public String getTableName() {
        return tableName;
    }

    public String getNom() {
        return nom;
    }

    public Conditions setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getOperateur() {
        return operateur;
    }

    public Conditions setOperateur(String operateur) {
        this.operateur = operateur;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Conditions setValue(String value) {
        this.value = value;
        return this;
    }

    public String getScore() {
        return score;
    }

    public Conditions setScore(String score) {
        this.score = score;
        return this;
    }

    public String getArguments() {
        return arguments;
    }

    public Conditions setArguments(String arguments) {
        this.arguments = arguments;
        return this;
    }
}
