package webappli.models;

import java.util.Date;

public class AdminModel extends BaseModelORM {
    private Integer id;
    private String nom;
    private String prenom;
    private String ident;
    private String password;
    private String birthday;
    private String adresse;
    private String mail;
    private String telephone;
    private String tableName;

    public Integer getId() {
        return id;
    }


    public String getNom() {
        return nom;
    }

    public AdminModel setNom(String nom) {
        this.nom = nom;

        return this;
    }

    public String getPrenom() {
        return prenom;
    }

    public AdminModel setPrenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public String getIdent(String ident) {
        return this.ident;
    }

    public AdminModel setIdent(String ident) {
        this.ident = ident;
        return this;
    }

    public String getPassword(String password) {
        return this.password;
    }

    public AdminModel setPassword(String password) {
        this.password = password;
        return this;


    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMail(String mail) {
        return this.mail;
    }

    public AdminModel setMailPro(String mail) {
        this.mail = mail;
        return this;
    }

    public String getTelephone() {
        return telephone;
    }

    public AdminModel setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }


    @Override
    public String getTableName() {
        this.tableName = "bradmin";
        return this.tableName;
    }
}
