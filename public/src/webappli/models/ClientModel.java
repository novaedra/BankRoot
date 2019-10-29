package webappli.models;

import webappli.utils.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ClientModel extends BaseModelORM {
    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private String telephone;
    private String adresse;
    private Date dateNaiss;
    private int enfants;
    private boolean autoCnil;
    private boolean prospect;
    private int statusPro_id;
    private int statusPerso_id;
    private float age;
    private String labelPro;
    private String labelPerso;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(Date dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public int getEnfants() {
        return enfants;
    }

    public void setEnfants(int enfants) {
        this.enfants = enfants;
    }

    public boolean isAutoCnil() {
        return autoCnil;
    }

    public void setAutoCnil(boolean autoCnil) {
        this.autoCnil = autoCnil;
    }

    public boolean isProspect() {
        return prospect;
    }

    public void setProspect(boolean prospect) {
        this.prospect = prospect;
    }

    public int getStatusPro_id() {
        return statusPro_id;
    }

    public void setStatusPro_id(int statusPro_id) {
        this.statusPro_id = statusPro_id;
    }

    public int getStatusPerso_id() {
        return statusPerso_id;
    }

    public void setStatusPerso_id(int statusPerso_id) {
        this.statusPerso_id = statusPerso_id;
    }

    public float getAge() {
        int age;
        Date date = dateNaiss;
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateNaiss = dateFormat.format(date);
        String[] parts = dateNaiss.split("-");
        String part1 = parts[0];
        String part2 = parts[1];
        String part3 = parts[2];

        int year = Integer.parseInt(part1);
        int month = Integer.parseInt(part2);
        int day = Integer.parseInt(part3);
        Calendar today = Calendar.getInstance();
        int actualYear = today.get(Calendar.YEAR);
        int actualMonth = today.get(Calendar.MONTH);
        int actualDay = today.get(Calendar.DAY_OF_MONTH);
        if (month > actualMonth) {
            age = (actualYear - year) - 1;
        } else if (month == actualMonth && day > actualDay) {
            age = (actualYear - year) - 1;
        } else {
            age = actualYear - year;
        }

        return age;
    }

    public void setAge(float age) {
        this.age = age;
    }

//   // public String getStatusPro() {
//        try {
//
//
//            Connection connection = Database.connect();
//            Statement statement = connection.createStatement();
//            ResultSet data = statement.executeQuery("SELECT * FROM statusPro WHERE id='" + statusPro_id + "'");
//
//            while (data.next()) {
//
//                String labelPro = data.getString("label");
//
//                return labelPro;
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public void setStatusPro(String labelPro) {
        this.labelPro = labelPro;
    }

//    public String getStatusPerso() {
//        try {
//            Connection connection = Database.connect();
//            Statement statement = connection.createStatement();
//
//            ResultSet data = statement.executeQuery("SELECT * FROM statusPerso WHERE id='" + statusPerso_id + "'");
//
//            while (data.next()) {
//                String labelPerso = data.getString("label");
//
//                return labelPerso;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public void setStatusPerso(String labelPerso) {
        this.labelPerso = labelPerso;
    }

    @Override
    public String getTableName() {
        this.tableName = "clients";
        return this.tableName;
    }
}
