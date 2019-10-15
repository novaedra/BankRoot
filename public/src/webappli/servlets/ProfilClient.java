package webappli.servlets;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import webappli.utils.Clients;
import webappli.utils.CompteClient;


@WebServlet(name = "ServletProfil",
        urlPatterns = "/ProfilClient")
public class ProfilClient extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        try {

            String id = request.getParameter("id");
            List result = Clients.selectClients(id);
            String iduser = request.getParameter("id");

            List results = CompteClient.selectCompte(iduser);

            request.setAttribute("comptes", results);
            request.setAttribute("clients", result);

        }catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher View = request.getRequestDispatcher("Client/infosClient.jsp");
        View.forward(request,response);
    }
}