package com.servlets;

import com.models.Clients;
import com.utils.database.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AllClient", urlPatterns = "/allClient")
public class detailClient extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Clients clients = new Clients();
        ArrayList f = new ArrayList();

        f.add("*");
        List resultat = Database.select(clients, f);
        request.setAttribute("resultat", resultat);
        request.getRequestDispatcher("allClient.jsp").forward(request, response);
    }
}