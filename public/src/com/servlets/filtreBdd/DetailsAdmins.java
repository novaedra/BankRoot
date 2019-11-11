package com.servlets.filtreBdd;

import com.models.Admins;
import com.utils.database.Database;
import com.utils.database.Filtre;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DetailsAdmins", urlPatterns = "/DetailsAdmins")
public class DetailsAdmins extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int admin_id = Integer.parseInt(id);
        String password = request.getParameter("hash");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String mail = request.getParameter("mail");
        String telephone = request.getParameter("telephone");
        String role = request.getParameter("role");
        String birthday = request.getParameter("birthday");

        Admins updAdmin = new Admins()
                .setNom(nom)
                .setPrenom(prenom)
                .setMail(mail)
                .setTelephone(telephone)
                .setRole(role)
                .setBirthday(birthday)
                .setPassword(password)
                .setCreated_at(null)
                .setUpdated_at(Timestamp.valueOf(LocalDateTime.now()));
        Database.updateId(updAdmin, admin_id);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* On récupère l'id de l'url */
        String id_Admins = request.getParameter("id");

        /* et on construit la requête : SELECT * FROM bradmin WHERE id ='?' */
        Admins admins = new Admins();
        ArrayList filters = new ArrayList();
        ArrayList<String> fields = new ArrayList<>();
        fields.add("*");
        filters.add(Filtre.add("=", "id", id_Admins));
        List<Admins> resultat = Database.select(admins, fields, filters);

        request.setAttribute("resultat", resultat);
        request.getRequestDispatcher("detailsAdmins.jsp").forward(request, response);

    }
}
