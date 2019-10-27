package webappli.utils;

import java.sql.DriverManager;
import java.sql.Connection;

public class Database {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bankroot";
            String user = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}