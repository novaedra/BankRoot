package com.servlets.conditions;

import com.models.Conditions;
import com.utils.database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AjoutCondition")
public class AjoutCondition extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nom = request.getParameter("nom");
        String argument = request.getParameter("argument");
        String operateur = request.getParameter("operateur");
        String valeur = request.getParameter("valeur");

        Conditions conditions = new Conditions()
                .setNom(nom)
                .setArgument(argument)
                .setOperateur(operateur)
                .setValeur(valeur);
        Database.insert(conditions);

        request.getRequestDispatcher("ajoutCondition.jsp").forward(request, response);
        response.sendRedirect("Liste-Conditions");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("ajoutCondition.jsp").forward(request, response);

    }
}
