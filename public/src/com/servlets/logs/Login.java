package com.servlets.logs;


import org.mindrot.jbcrypt.BCrypt;
import com.models.Admins;
import com.utils.database.Database;
import com.utils.database.Filtre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Login", urlPatterns = "/Login")
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Admins admins = new Admins();
        List<String> adminMail = new ArrayList<>();
        ArrayList<String> fields = new ArrayList<>();

        fields.add("*");

        ArrayList filters = new ArrayList();
        String mail = request.getParameter("mail");
        List<Admins> selMail = Database.select(admins, fields);

        for (Admins admin : selMail) {
            adminMail.add(admin.getMail());
        }
        if (adminMail.contains(mail) && mail.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
            mail = "'" + mail + "'";
            filters.add(Filtre.add("=", "mail", mail));
            List<Admins> selMdp = Database.select(admins, fields, filters);
            String password = "?";
            for (Admins adminSelect : selMdp) {
                password = adminSelect.getPassword();

                if (BCrypt.checkpw(request.getParameter("password"), password)) {
                    System.out.println("Connexion OK.");

                    /*Initialisation de la session*/
                    HttpSession session = request.getSession(true);
                    session.setAttribute("mail", adminSelect.getMail());
                    session.setAttribute("id", adminSelect.getId());
                    session.setAttribute("prenom", adminSelect.getPrenom());
                    session.setAttribute("nom", adminSelect.getNom());
                    session.setAttribute("role", adminSelect.getRole());
                    session.setAttribute("birthday", adminSelect.getBirthday());
                    session.setAttribute("telephone", adminSelect.getTelephone());
                    session.setAttribute("password", password);
                    session.setMaxInactiveInterval(300);
                    response.sendRedirect("dashboard.jsp");
                } else {
                    System.out.println("Connexion refusée.");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
        } else {
            System.out.println("Connexion refusée.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}