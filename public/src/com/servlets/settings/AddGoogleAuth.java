package com.servlets.settings;

import com.models.Admins;
import com.utils.GoogleAuth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "AddGoogleAuth")
public class AddGoogleAuth extends HttpServlet {
    private Admins getAdmins() {
        Admins admins = new Admins();

        admins.setMail("michel@gmail.com");
        admins.setTwoFactorKey("UOPKN6QFW3J6PW74");
        admins.setId(123);

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
        request.getRequestDispatcher("reglages.jsp").forward(request, response);

    }
}
