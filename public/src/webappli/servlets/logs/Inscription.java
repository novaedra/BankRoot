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
    public static final String VUE = "/inscription.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        InscriptionForm form = new InscriptionForm();
        Admins admins = form.ajoutAdmin(request);
        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_USER, admins);

        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
    }

}
