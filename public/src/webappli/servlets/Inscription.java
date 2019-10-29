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
        String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));

        System.out.println("[DB] Try to insert new Admin");
        AdminModel _newAdmin = new AdminModel();

        _newAdmin.setNom(nom);
        _newAdmin.setMailPro(mail);
        _newAdmin.setPassword(hash);
        Integer id = Database.insert(_newAdmin);

        request.setAttribute("nom", nom);
        request.setAttribute("mail", mail);
        request.setAttribute("password", hash);
        RequestDispatcher view = request.getRequestDispatcher("viewInscription.jsp");
        view.forward(request, response);
    }
}
