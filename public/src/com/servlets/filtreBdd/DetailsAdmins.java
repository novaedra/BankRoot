package com.servlets.filtreBdd;

import com.models.Admins;
import com.utils.database.Database;
import com.utils.database.Filtre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DetailsAdmins", urlPatterns = "/DetailsAdmins")
public class DetailsAdmins extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admins admins = new Admins();
        List<String> adminMail = new ArrayList<>();
        ArrayList<String> fields = new ArrayList<>();

        fields.add("*");
        ArrayList filters = new ArrayList();

        String mailAdmin = request.getParameter("mail");
        List<Admins> selMail = Database.select(admins, fields);
        for (Admins _adminMail : selMail) {
            mailAdmin = _adminMail.getMail();
        }
        mailAdmin = "'" + mailAdmin + "'";
        filters.add(Filtre.add("=", "mail", mailAdmin));
        List<Admins> resultat = Database.select(admins, fields, filters);

        for (Admins admin : resultat) {
            adminMail.add(admin.getMail());

        }

        request.setAttribute("resultat", resultat);
        request.getRequestDispatcher("detailsAdmins.jsp").forward(request, response);

    }
}
