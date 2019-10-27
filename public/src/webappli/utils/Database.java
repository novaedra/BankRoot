package webappli.utils;

import java.sql.DriverManager;
import java.sql.Connection;

public class Database {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jbdc:mysql://localhost:3306/bankroot", "root", "");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}