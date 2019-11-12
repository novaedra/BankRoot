package com.servlets.settings;

import com.models.Admins;
import com.utils.GoogleAuth;

import javax.management.modelmbean.RequiredModelMBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AddGoogleAuth")
public class EnableGoogleAuth extends HttpServlet {
    private HttpServletRequest request;
    private HttpSession session = request.getSession();
    public final String mail = (String) session.getAttribute("mail");
    public final Integer id = (Integer) session.getAttribute("id");

    private Admins getAdmins() {
        Admins admins = (Admins) new Admins()
                .setMail(mail)
                .setId(id);
        admins.setTwoFactorKey("UOPKN6QFW3J6PW74");

        return admins;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Admins admins = getAdmins();
        GoogleAuth gAuth = new GoogleAuth();

        String base64Code = "";

        try {
            Map _qrCode = gAuth.qrCodeGeneration(admins);
            base64Code = _qrCode.get("base64Image").toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        request.setAttribute("qrCode", base64Code);
        request.getRequestDispatcher("doubleAuthentification.jsp").forward(request, response);

    }
}
