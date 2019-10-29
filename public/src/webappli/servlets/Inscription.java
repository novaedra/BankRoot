package webappli.servlets;

import webappli.models.AdminModel;
import webappli.utils.BCrypt;
import webappli.utils.Database;

import javax.resource.spi.AdministeredObject;
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
    //  String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));

        System.out.println("[DB] Try to insert new Admin");
        AdminModel _newAdmin = new AdminModel();

        _newAdmin.setNom(nom);
        _newAdmin.setMailPro(mail);
        _newAdmin.setPassword(password);
        Integer id = Database.insert(_newAdmin);

//        try {
//
//            Connection connection = Database.connect();
//            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO admin(nom, mail, password) VALUES (?,?,?)");
//            preparedStatement.setString(1, nom);
//            preparedStatement.setString(2, mail);
//            preparedStatement.setString(3, hash);
//
//            System.out.print(preparedStatement.toString());
//
//            preparedStatement.executeUpdate();
//        } catch (Exception e) {
//            System.err.print(e.getMessage());
//            e.printStackTrace();
//        }
        request.setAttribute("nom", nom);
        request.setAttribute("mail", mail);
        request.setAttribute("password", password);
        RequestDispatcher view = request.getRequestDispatcher("viewInscription.jsp");
        view.forward(request, response);
    }
}
