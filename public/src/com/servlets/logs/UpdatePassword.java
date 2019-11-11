package com.servlets.logs;

import org.mindrot.jbcrypt.BCrypt;
import com.models.Admins;
import com.utils.database.Database;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@WebServlet(name = "UpdatePassword", urlPatterns = "/UpdatePassword")
public class UpdatePassword extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* Récupération des données en session */
        HttpSession _updSess = request.getSession();
        String sPrenom = (String) _updSess.getAttribute("prenom");
        String sNom = (String) _updSess.getAttribute("nom");
        String sRole = (String) _updSess.getAttribute("role");
        String sMail = (String) _updSess.getAttribute("mail");
        String sTelephone = (String) _updSess.getAttribute("telephone");
        String sBirthday = (String) _updSess.getAttribute("birthday");
        String sPassword = (String) _updSess.getAttribute("password");
        Timestamp sCreated_at = (Timestamp) _updSess.getAttribute("sCreated_at");
        Integer id = (Integer) _updSess.getAttribute("id");

        /* Données du formulaire */
        String password = request.getParameter("newPassword");
        String oldPassword = request.getParameter("oldPassword");

        /* Chiffrement du mot de passe */
        String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));

        /* On vérifie que le mot de passe saisi corresponde à celui en session (login) */
        if (BCrypt.checkpw(oldPassword, sPassword)) {
            /* On vérifie que le nouveau mot de passe soit différent de celui en session (login) */
            if (!BCrypt.checkpw(password, sPassword)) {
                /* 8 caractères minimum + confirmation du mot de passe => OK = Mise à jour en bdd */
                if (password.length() > 8 || password.equals(request.getParameter("newConfirmation"))) {
                    Admins updPass = new Admins()
                            .setPassword(hash)
                            .setMail(sMail)
                            .setNom(sNom)
                            .setPrenom(sPrenom)
                            .setTelephone(sTelephone)
                            .setBirthday(sBirthday)
                            .setRole(sRole)
                            .setCreated_at(sCreated_at)
                            .setUpdated_at(Timestamp.valueOf(LocalDateTime.now()));
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
