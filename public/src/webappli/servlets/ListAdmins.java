package webappli.servlets;

import webappli.models.Admins;
import webappli.utils.Database;

import javax.servlet.RequestDispatcher;
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

        Admins admins = new Admins();
        List<String> adminList = new ArrayList<>();
        ArrayList<String> fields = new ArrayList<>();
        fields.add("*");

        ArrayList filters = new ArrayList();
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String mail = request.getParameter("mail");
        String birthday = request.getParameter("birthday");
        String telephone = request.getParameter("telephone");
        List<Admins> selList = Database.select(admins, fields);

        for (Admins admin : selList) {
            adminList.add(admin.getNom() + admin.getPrenom() + admin.getMail() + admin.getBirthday() + admin.getTelephone());
        }

        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);
    }
}
