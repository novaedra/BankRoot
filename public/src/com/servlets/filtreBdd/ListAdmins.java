package com.servlets.filtreBdd;

import com.models.Admins;
import com.utils.database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListAdmins")
public class ListAdmins extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* SELECT * FROM bradmin */
        Admins admins = new Admins();
        ArrayList f = new ArrayList();
        f.add("*");
        List resultat = Database.select(admins, f);
        request.setAttribute("resultat", resultat);
        request.getRequestDispatcher("listeAdmins.jsp").forward(request, response);

    }
}
