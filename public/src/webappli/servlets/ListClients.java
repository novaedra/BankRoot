package webappli.servlets;

import webappli.models.AdminModel;
import webappli.models.ClientModel;
import webappli.utils.Database;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListClients", urlPatterns = "/ListClients")
public class ListClients extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
//        try {
//            Connection connection = Database.connect();
//            Statement statement = connection.createStatement();
//            ResultSet data = statement.executeQuery("SELECT * FROM clients");
//            List<ClientModel> result = new ArrayList<>();
//            while (data.next()) {
//                ClientModel clients = new ClientModel();
//                clients.setId(data.getInt("id"));
//                clients.setNom(data.getString("nom"));
//                clients.setPrenom(data.getString("prenom"));
//                clients.setMail(data.getString("mail"));
//                clients.setTelephone(data.getString("telephone"));
//                clients.setAdresse(data.getString("adresse"));
//                clients.setDateNaiss(data.getDate("dateNaiss"));
//                clients.setEnfants(data.getInt("enfants"));
//                clients.setAutoCnil(data.getBoolean("autoCnil"));
//                clients.setProspect(data.getBoolean("prospect"));
//                clients.setStatusPro_id(data.getInt("statusPro"));
//                clients.setStatusPerso_id(data.getInt("statusPerso"));
//                clients.setAge(clients.getAge());
//                clients.setStatusPro(clients.getStatusPro());
//                clients.setStatusPerso(clients.getStatusPerso());
//                result.add(clients);
//
//            }
//            request.setAttribute("result", result);
//            RequestDispatcher view = request.getRequestDispatcher("liste.jsp");
//            view.forward(request, response);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}