package com.models;

public class Categories extends BaseModelORM {

    private Integer id_categorie;
    private String nom;
    private String tableName;

    public Integer getId_categorie() {
        return id_categorie;
    }

    public Categories setId_categorie(Integer id_categorie) {
        this.id_categorie = id_categorie;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public Categories setNom(String nom) {
        this.nom = nom;
        return this;
    }
    @Override
    public String getTableName() {
        this.tableName = "brcategories";
        return this.tableName;
    }

}
