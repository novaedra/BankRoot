package com.servlets.filtreBdd;

import com.models.Admins;
import com.utils.database.Database;
import com.utils.database.Filtre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DetailsAdmins", urlPatterns = "/DetailsAdmins")
public class DetailsAdmins extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* On récupère l'id de l'url */
        String id_Admins = request.getParameter("id");

        /* et on construit la requête : SELECT * FROM bradmin WHERE id ='?' */
        Admins admins = new Admins();
        ArrayList filters = new ArrayList();
        ArrayList<String> fields = new ArrayList<>();
        fields.add("*");
        id_Admins = "'" + id_Admins + "'";
        filters.add(Filtre.add("=", "id", id_Admins));
        List<Admins> resultat = Database.select(admins, fields, filters);

        request.setAttribute("resultat", resultat);
        request.getRequestDispatcher("detailsAdmins.jsp").forward(request, response);

    }
}
