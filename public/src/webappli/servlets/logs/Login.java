package webappli.servlets.logs;


import webappli.models.Admins;
import webappli.utils.securite.BCrypt;
import webappli.utils.database.Database;
import webappli.utils.database.Filtre;

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
            for (Admins adminMdp : selMdp) {
                password = adminMdp.getPassword();
            }
            if (BCrypt.checkpw(request.getParameter("password"), password)) {
                System.out.println("Connexion OK.");

            } else {
                System.out.println("Connexion refusée.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            List<Admins> selRole = Database.select(admins, fields, filters);
            String role = "?";
            for (Admins admins1 : selRole) {
                role = admins1.getRole();
            }
            List<Admins> selPrenom = Database.select(admins, fields, filters);
            String prenom = "?";
            for (Admins admins1 : selRole) {
                prenom = admins1.getPrenom();

            }
            List<Admins> selNom = Database.select(admins, fields, filters);
            String nom = "?";
            for (Admins admins1 : selRole) {
                nom = admins1.getNom();
            }
            HttpSession session = request.getSession(true);
            session.setAttribute("mail", mail);
            session.setAttribute("prenom", prenom);
            session.setAttribute("nom", nom);
            session.setAttribute("role", role);
            session.setMaxInactiveInterval(300);
            response.sendRedirect("dashboard.jsp");

        } else {
            System.out.println("Connexion refusée.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}