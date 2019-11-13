package com.servlets.filtreBdd;

import com.models.Produits;
import com.utils.database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListProduits", urlPatterns = "/Liste-Produits")
public class ListProduits extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Produits produits = new Produits();
        ArrayList f = new ArrayList();

        f.add("*");

        List resultat = Database.select(produits, f);
        request.setAttribute("resultat", resultat);

        request.getRequestDispatcher(".jsp").forward(request, response);
    }
}
