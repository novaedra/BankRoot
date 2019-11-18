package com.servlets.produits;

import com.models.Categories;
import com.models.Produits;
import com.utils.database.Database;
import com.utils.database.Filtre;

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

@WebServlet(name = "DetailsProduits", urlPatterns = "/DetailsProduits")
public class DetailsProduits extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_prod = request.getParameter("id_prod");
        System.out.println(id_prod);
        String nom = request.getParameter("nom");
        System.out.println(nom);
        String categorie_id = request.getParameter("categorie_id");
        System.out.println(categorie_id);
        String taux = request.getParameter("taux");
        System.out.println(taux);
        String frais = request.getParameter("frais");
        System.out.println(frais);
        String description = request.getParameter("description");
        System.out.println(description);
        Integer _id_prod = Integer.parseInt(id_prod);
        System.out.println(id_prod);
        Integer _categorie_id = Integer.parseInt(categorie_id);
        System.out.println(_categorie_id);
        Integer _taux = Integer.parseInt(taux);
        System.out.println(_taux);
        Integer _frais = Integer.parseInt(frais);
        System.out.println(_frais);

        Produits produits = new Produits()
                .setNom(nom)
                .setTaux(_taux)
                .setFrais(_frais)
                .setDescription(description)
                .setId_categorie(_categorie_id)
                .setUpdated_at(Timestamp.valueOf(LocalDateTime.now()));
        Database.updateId(produits, _id_prod);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_produits = request.getParameter("id_prod");

        /* et on construit la requête : SELECT * FROM bradmin WHERE id ='?' */

        Produits produits = new Produits();
        ArrayList filters = new ArrayList();
        ArrayList<String> fields = new ArrayList<>();
        fields.add("*");
        filters.add(Filtre.add("=", "id", id_produits));
        List<Produits> resultat = Database.select(produits, fields, filters);

        Categories _categories = new Categories();
        List categories = Database.select(_categories, fields);
        request.setAttribute("categories", categories);
        request.setAttribute("resultat", resultat);
        request.getRequestDispatcher("detailsProduits.jsp").forward(request, response);
    }
}
