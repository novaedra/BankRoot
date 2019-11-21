package com.models;

import org.joda.time.DateTime;

import java.sql.Timestamp;

public class Historique extends BaseModelORM {

    private Integer id_historique;
    private Integer id_client;
    private Integer id_produit;
    private boolean statut;
    private Integer id_admin;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String tableName = "brhistorique";

    public String getTableName() {
        return tableName;
    }

    public Integer getId_historique() {
        return id_historique;
    }

    public Historique setId_historique(Integer id_historique) {
        this.id_historique = id_historique;
        return this;
    }

    public Integer getId_client() {
        return id_client;
    }

    public Historique setId_client(Integer id_client) {
        this.id_client = id_client;
        return this;
    }

    public Integer getId_produit() {
        return id_produit;
    }

    public Historique setId_produit(Integer id_produit) {
        this.id_produit = id_produit;
        return this;
    }

    public boolean getStatut() {
        return statut;
    }

    public Historique setStatut(boolean statut) {
        this.statut = statut;
        return this;
    }



    public Integer getId_admin() {
        return id_admin;
    }

    public Historique setId_admin(Integer id_admin) {
        this.id_admin = id_admin;
        return this;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public Historique setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
        return this;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public Historique setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
        return this;
    }
}
