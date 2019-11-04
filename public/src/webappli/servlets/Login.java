package webappli.servlets;


import webappli.models.Admins;
import webappli.utils.BCrypt;
import webappli.utils.Database;
import webappli.utils.Filtre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        if (adminMail.contains(mail)) {
            System.out.println("");
            mail = "'" + mail + "'";
            filters.add(Filtre.add("=", "mail", mail));
            List<Admins> selMdp = Database.select(admins, fields, filters);
            String password = "";
            for (Admins adminMdp : selMdp) {
                password = adminMdp.getPassword();
            }
            if (BCrypt.checkpw(request.getParameter("password"), password)) {
                System.out.println("Connexion OK.");
            } else {
                System.out.println("Connexion refusée.");
            }
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}