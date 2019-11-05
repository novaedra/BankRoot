package webappli.servlets;

import webappli.models.Admins;
import webappli.utils.BCrypt;
import webappli.utils.Database;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Inscription", urlPatterns = "/Inscription")
public class Inscription extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String mail = request.getParameter("mail");
        String telephone = request.getParameter("telephone");
        String birthday = request.getParameter("birthday");
        String password = request.getParameter("password");
        String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));

        System.out.println("[DB] Try to insert new Admin");
        Admins _newAdmin = new Admins();
        _newAdmin.setNom(nom);
        _newAdmin.setPrenom(prenom);
        _newAdmin.setMail(mail);
        _newAdmin.setTelephone(telephone);
        _newAdmin.setBirthday(birthday);
        _newAdmin.setPassword(hash);
        Database.insert(_newAdmin);

        request.setAttribute("nom", nom);
        request.setAttribute("prenom", prenom);
        request.setAttribute("mail", mail);
        request.setAttribute("telephone", telephone);
        request.setAttribute("birthday", birthday);
        request.setAttribute("password", hash);
        RequestDispatcher view = request.getRequestDispatcher("viewInscription.jsp");
        view.forward(request, response);
    }
}
