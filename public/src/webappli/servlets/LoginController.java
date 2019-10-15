package webappli.servlets;

import com.webappli.utils.Database;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name=request.getParameter("nom");
        String password=request.getParameter("mdp");
        String firstname=request.getParameter("prenom");

        HttpSession session = request.getSession();

        session.setAttribute("nom",name);
        session.setAttribute("prenom",firstname);

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = Database.connect();

            PreparedStatement ps = connect.prepareStatement("select * from BKadmin where nom=? and mdp=?");
            ps.setString(1, name);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                this.getServletContext().getRequestDispatcher("/showClients.jsp").forward(request,response);
                return;
            }
            this.getServletContext().getRequestDispatcher("/error.jsp").forward(request,response);
            return;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
