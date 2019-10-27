package webappli.servlets;

import webappli.utils.BCrypt;
import webappli.utils.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "Login", urlPatterns = "/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");
        String login = null;

        try {
            Connection connection = Database.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM admin WHERE mail=?");
            statement.setString(1, mail);
            ResultSet data = statement.executeQuery();

            while (data.next()) {
                String id = data.getString("id");
                String nom = data.getString("nom");
                String mailLog = data.getString("mail");
                String passwordLog = data.getString("password");


                boolean matched = BCrypt.checkpw(password, passwordLog);

                if (matched) {
                    login = "Connexion réussie.";
                    HttpSession idUser = request.getSession();
                    idUser.setAttribute("idUser", id);

                } else {
                    login = "Echec connexion";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("login", login);
        response.sendRedirect("/bankroot/Index");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
