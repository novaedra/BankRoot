package com.models;


import java.sql.Timestamp;

public class Produits extends BaseModelORM {


    private Integer id;
    private String nom;
    private Integer taux;
    private Integer frais;
    private String description;
    private Timestamp created_at;
    private Timestamp updated_at;
    String tableName = "brproduits";

    public String getTableName() {
        return tableName;
    }

    public String getNom() {
        return nom;
    }

    public Produits setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public Integer getTaux() {
        return taux;
    }

    public Produits setTaux(Integer taux) {
        this.taux = taux;
        return this;
    }

    public Integer getFrais() {
        return frais;
    }

    public Produits setFrais(Integer frais) {
        this.frais = frais;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Produits setDescription(String description) {
        this.description = description;
        return this;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Produits setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
        return this;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public Produits setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
        return this;
    }

}
