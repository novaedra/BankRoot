package com.servlets.produits;

import com.models.Categories;
import com.models.Produits;
import com.utils.controllers.InscriptionForm;
import com.utils.database.Database;

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

@WebServlet(name = "AjoutProduits")
public class AjoutProduit extends HttpServlet {
    public static final String ATT_USER = "admins";
    public static final String ATT_FORM = "form";
    public static final String VUE = "/ajoutProduits.jsp";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        InscriptionForm form = new InscriptionForm();
        Produits produits = form.ajoutProduits(request);
        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_USER, produits);
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
        response.sendRedirect("dashboard.jsp");
        response.sendRedirect("Liste-Produits");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Categories categories = new Categories();
        ArrayList f = new ArrayList();

        f.add("*");

        List resultat = Database.select(categories, f);
        request.setAttribute("resultat", resultat);

        request.getRequestDispatcher("ajoutProduits.jsp").forward(request, response);
    }
}
