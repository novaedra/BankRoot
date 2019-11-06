package webappli.servlets;

import webappli.models.Admins;
import webappli.utils.BCrypt;
import webappli.utils.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Inscription", urlPatterns = "/Inscription")
public class Inscription extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String mail = request.getParameter("mail");
        String telephone = request.getParameter("telephone");
        String birthday = request.getParameter("birthday");
        Integer supAdmin = Integer.getInteger(request.getParameter("supAdmin"));
        String password = request.getParameter("password");
        String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
        System.out.println("[DB] Try to insert a new Admin");

        Admins _newAdmin = new Admins()
                .setNom(nom)
                .setPrenom(prenom)
                .setMail(mail)
                .setTelephone(telephone)
                .setBirthday(birthday)
                .setSupAdmin(supAdmin)
                .setPassword(hash);
        Database.insert(_newAdmin);

        request.setAttribute("nom", nom);
        request.setAttribute("prenom", prenom);
        request.setAttribute("mail", mail);
        request.setAttribute("telephone", telephone);
        request.setAttribute("birthday", birthday);
        request.setAttribute("supAdmin", supAdmin);
        request.setAttribute("password", hash);
        request.getRequestDispatcher("viewInscription.jsp").forward(request, response);
    }
}
