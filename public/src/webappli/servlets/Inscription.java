package webappli.servlets;

import webappli.utils.BCrypt;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(name = "Inscription", urlPatterns = "/Inscription")
public class Inscription extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String mail = request.getParameter("mail");
        String password = request.getParameter("password");
        String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankroot?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO admin(nom, mail, password) VALUES (?,?,?)");
            preparedStatement.setString(1, nom);
            preparedStatement.setString(2, mail);
            preparedStatement.setString(3, hash);

            System.out.print(preparedStatement.toString());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.err.print(e.getMessage());
            e.printStackTrace();
        }
        request.setAttribute("nom", nom);
        request.setAttribute("mail", mail);
        request.setAttribute("password", password);
        RequestDispatcher view = request.getRequestDispatcher("viewInscription.jsp");
        view.forward(request, response);
    }
}
