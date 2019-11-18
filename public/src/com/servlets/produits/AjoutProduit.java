package com.servlets.produits;

import com.models.Categories;
import com.models.Produits;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String categorie = request.getParameter("categorie");
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        String taux = request.getParameter("taux");
        String frais = request.getParameter("frais");
        String categorie_id = request.getParameter("categorie_id");
        Integer _categorie_id = Integer.parseInt(categorie_id);
        Integer _taux = Integer.parseInt(taux);
        Integer _frais = Integer.parseInt(frais);
        System.out.println("[DB] Try to insert a new product.");
        Produits addProduit = new Produits()
                .setNom(nom)
                .setDescription(description)
                .setTaux(_taux)
                .setFrais(_frais)
                .setId_categorie(_categorie_id)
                .setCreated_at(Timestamp.valueOf(LocalDateTime.now()))
                .setUpdated_at(null);
        Database.insert(addProduit);
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
