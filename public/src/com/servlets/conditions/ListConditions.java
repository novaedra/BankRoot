package com.servlets.conditions;

import com.models.Conditions;
import com.utils.database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListConditions")
public class ListConditions extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Conditions conditions = new Conditions();
        ArrayList f = new ArrayList();

        f.add("*");

        List resultat = Database.select(conditions, f);
        request.setAttribute("resultat", resultat);
        request.getRequestDispatcher("listeConditions.jsp").forward(request, response);
    }
}
