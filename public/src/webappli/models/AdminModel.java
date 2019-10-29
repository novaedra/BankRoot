package webappli.models;

import java.util.Date;

public class AdminModel extends BaseModelORM {
    private Integer id;
    private String nom;
    private String prenom;
    private String password;
    // private String datenaiss;
    // private String adresse;
    private String mail;
    // private String mailPerso;
    private String telephone;
    // private String telPerso;
    // private Boolean SupAdmin;
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

    public String getPassword() {
        return password;
    }

    public AdminModel setPassword(String password) {
        this.password = password;
        return this;


    }

//    public String getDateNaiss() {
//        return datenaiss;
//    }
//
//    public AdminModel setDateNaiss(String datenaiss) {
//        this.datenaiss = datenaiss;
//        return this;
//    }
//
//    public String getAdresse() {
//        return adresse;
//    }
//
//    public void setAdresse(String adresse) {
//        this.adresse = adresse;
//    }

    public String getMail() {
        return mail;
    }

    public AdminModel setMailPro(String mail) {
        this.mail = mail;
        return this;
    }

    //    public String getMailPerso() {
//        return mailPerso;
//    }
//
//    public void setMailPerso(String mailPerso) {
//        this.mailPerso = mailPerso;
//    }
//
    public String getTelephone() {
        return telephone;
    }

    public AdminModel setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }
//
//    public String getTelPerso() {
//        return telPerso;
//    }
//
//    public void setTelPerso(String telPerso) {
//        this.telPerso = telPerso;
//    }
//
//    public Boolean getSupAdmin() {
//        return SupAdmin;
//    }
//
//    public void setSupAdmin(Boolean supAdmin) {
//        SupAdmin = supAdmin;
//    }

    @Override
    public String getTableName() {
        this.tableName = "bradmin";
        return this.tableName;
    }
}
