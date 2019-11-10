package webappli.servlets.logs;

import org.mindrot.jbcrypt.BCrypt;
import webappli.models.Admins;
import webappli.utils.database.Database;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UpdateAtA")
public class UpdateAtA extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession _updSess = request.getSession();
        String sPrenom = (String) _updSess.getAttribute("prenom");
        String sNom = (String) _updSess.getAttribute("nom");
        String sRole = (String) _updSess.getAttribute("role");
        String sMail = (String) _updSess.getAttribute("mail");
        String sTelephone = (String) _updSess.getAttribute("telephone");
        String sBirthday = (String) _updSess.getAttribute("birthday");
        String sPassword = (String) _updSess.getAttribute("password");
        String password = request.getParameter("newPassword");
        String oldPassword = request.getParameter("oldPassword");
        Integer id = (Integer) _updSess.getAttribute("id");
        String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
        if (BCrypt.checkpw(oldPassword, sPassword)) {
            if (!BCrypt.checkpw(password, sPassword)) {
                if (password != null || password.equals(request.getParameter("newConfirmation"))) {
                    Admins updPass = new Admins()
                            .setPassword(hash)
                            .setMail(sMail)
                            .setNom(sNom)
                            .setPrenom(sPrenom)
                            .setTelephone(sTelephone)
                            .setBirthday(sBirthday)
                            .setRole(sRole);
                    Database.updateId(updPass, id);
                }
            }
        }
        request.getRequestDispatcher("reglages.jsp").forward(request, response);
        response.sendRedirect("reglages.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
