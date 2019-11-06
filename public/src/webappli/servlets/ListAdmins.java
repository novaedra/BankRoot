package webappli.servlets;

import webappli.models.Admins;
import webappli.utils.Database;
import webappli.utils.Filtre;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListAdmins")
public class ListAdmins extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Admins admins = new Admins();
        ArrayList f = new ArrayList();

        f.add("*");
        List resultat = Database.select(admins, f);

        System.out.println(admins);
        System.out.println(resultat);
        request.setAttribute("resultat", resultat);
        request.getRequestDispatcher("liste.jsp").forward(request, response);



//        Admins admins = new Admins();
//        ArrayList<String> fields = new ArrayList<>();
//        ArrayList filtre = new ArrayList();
//
//
//
//        filtre.add(Filtre.add("=", "nom", ""));
//        filtre.add(Filtre.add("=", "prenom", ""));
//        filtre.add(Filtre.add("=", "mail", ""));
//        System.out.println(filtre);
//        System.out.println(fields);
//        System.out.println(admins);
//        fields.add("nom");
//        fields.add("prenom");
//        fields.add("mail");
//
//        List resultat = Database.select(admins, fields, filtre);
//        System.out.println(resultat);
//        request.setAttribute("resultat", resultat);
//        request.getRequestDispatcher("liste.jsp").forward(request, response);

    }
}
