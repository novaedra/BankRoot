package webappli.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static Connection connect() {
        String url = "jbdc:mysql://localhost:5432/bankroot";
        String user = "root";
        String mdp = "root";

        Connection connexion = null;

        try {
            connexion = DriverManager.getConnection(url, user, mdp);
            return connexion;
        } catch (SQLException e) {
            System.err.println(e);

        }
        return null;
    }
}
