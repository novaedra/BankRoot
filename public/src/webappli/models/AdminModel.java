package webappli.models;

import java.util.Date;

public class AdminModel extends BaseModelORM {
    private int id;
    private String nom;
    private String prenom;
    private String identifiant;
    private String password;
    private Date dateNaiss;
    private String adresse;
    private String mailPro;
    private String mailPerso;
    private String telPro;
    private String telPerso;
    private Boolean SupAdmin;
    private String tableName;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMailPro() {
        return mailPro;
    }

    public void setMailPro(String mailPro) {
        this.mailPro = mailPro;
    }

    public String getMailPerso() {
        return mailPerso;
    }

    public void setMailPerso(String mailPerso) {
        this.mailPerso = mailPerso;
    }

    public String getTelPro() {
        return telPro;
    }

    public void setTelPro(String telPro) {
        this.telPro = telPro;
    }

    public String getTelPerso() {
        return telPerso;
    }

    public void setTelPerso(String telPerso) {
        this.telPerso = telPerso;
    }

    public Boolean getSupAdmin() {
        return SupAdmin;
    }

    public void setSupAdmin(Boolean supAdmin) {
        SupAdmin = supAdmin;
    }

    @Override
    public String getTableName() {
        this.tableName = "bradmin";
        return this.tableName;
    }
}
