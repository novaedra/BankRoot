package com.servlets;

import com.models.Produits;
import com.utils.Mail;
import com.utils.database.Database;
import com.utils.database.Filtre;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SendMail", urlPatterns = "/SendMail")
public class SendMail extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        Mail.sendMessage(subject, message, to, "bankroot.contact@gmail.com");
        response.sendRedirect("Dashboard");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destinataire = request.getParameter("dest");
        request.setAttribute("destinataire", destinataire);
        String id = request.getParameter("idproduit");
        Produits produits = new Produits();
        ArrayList filters = new ArrayList();
        ArrayList<String> fields = new ArrayList<>();
        fields.add("*");
        filters.add(Filtre.add("=", "id", id));
        List<Produits> res = Database.select(produits, fields, filters);
        String nom = "";
        String des = "";
        for (Produits produit : res) {
            nom = produit.getNom();
            des = produit.getDescription();
        }
        request.setAttribute("nom", nom);
        request.setAttribute("des", des);
        request.getRequestDispatcher("mail.jsp").forward(request, response);


    }
}
