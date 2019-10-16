package webappli.models;

import webappli.utils.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompteClient {
    private int id;
    private float montant;
    private Date date;
    private int idClient;

    public static List selectCompte(String id) {
        Connection connection = Database.connect();

        try {
            Statement statement = connection.createStatement();
            ResultSet data = statement.executeQuery("SELECT * FROM BKcompte WHERE idClient =" + id);
            List<CompteClient> results = new ArrayList<>();
            while (data.next()) {
                CompteClient compte = new CompteClient();

                compte.setId(data.getInt("id"));
                compte.setMontant(data.getFloat("montant"));

                results.add(compte);
            }
            return results;

        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
}
