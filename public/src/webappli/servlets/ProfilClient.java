package webappli.servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import webappli.models.Clients;
import webappli.models.CompteClient;


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