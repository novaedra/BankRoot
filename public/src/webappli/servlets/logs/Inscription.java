package webappli.servlets.logs;

import webappli.models.Admins;
import webappli.utils.securite.InscriptionForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Inscription", urlPatterns = "/Inscription")
public class Inscription extends HttpServlet {

    public static final String ATT_USER = "admins";
    public static final String ATT_FORM = "form";
    public static final String VUE = "inscription.jsp";
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        InscriptionForm form = new InscriptionForm();
        Admins admins = form.ajoutAdmin(request);

        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_USER, admins);

        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        String nom = request.getParameter("nom");
//        String prenom = request.getParameter("prenom");
//        String mail = request.getParameter("mail");
//        String telephone = request.getParameter("telephone");
//        String birthday = request.getParameter("birthday");
//        String role = request.getParameter("role");
//        String password = request.getParameter("password");
//        String hash = BCrypt.hashpw(password, BCrypt.gensalt(12));
//        System.out.println("[DB] Try to insert a new Admin");


//        Admins _newAdmin = new Admins()
//                .setNom(nom)
//                .setPrenom(prenom)
//                .setMail(mail)
//                .setTelephone(telephone)
//                .setBirthday(birthday)
//                .setRole(role)
//                .setPassword(hash);
//        Database.insert(_newAdmin);
//        request.setAttribute("nom", nom);
//        request.setAttribute("prenom", prenom);
//        request.setAttribute("mail", mail);
//        request.setAttribute("telephone", telephone);
//        request.setAttribute("birthday", birthday);
//        request.setAttribute("role", role);
//        request.setAttribute("password", hash);
//        request.getRequestDispatcher("viewInscription.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

}
