package webappli.models;

import webappli.utils.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Clients {

    private int id;

    private String nom;
    private String prenom;
    private Date DateNaissance;
    private String email;
    private String tel;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;

    }

    public static List selectClients(String id) {

        Connection connection = Database.connect();
        try {
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery("SELECT * FROM clients WHERE id = '" + id + "'");
            List<Clients> results = new ArrayList<>();

            while (data.next()) {
                Clients clients1 = new Clients();

                clients1.setId(data.getInt("id"));
                clients1.setNom(data.getString("nom"));
                clients1.setPrenom(data.getString("prenom"));
                clients1.setEmail(data.getString("mail"));
                clients1.setTelephone(data.getString("telephone"));

                results.add(clients1);
            }

            return results;
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;

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

    public Date getDateDeNaissance() {
        return DateNaissance;


    }

    public void setDateDeNaissance(Date DateNaissance) {
        this.DateNaissance = DateNaissance;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return tel;
    }

    public void setTelephone(String tel) {
        this.tel = tel;
    }


}
