<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    /* On contrôle qu'une session a été instanciée, sinon on redirige vers la page d'accueil */
    if (session != null) {
        if (session.getAttribute("mail") != null) {
            System.out.println("[SESSION] Connected.");
        } else {
            response.sendRedirect("Login");
        }
    }
%>