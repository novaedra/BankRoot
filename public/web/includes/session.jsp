<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session != null) {
        if (session.getAttribute("mail") != null) {
            String mail = (String) session.getAttribute("mail");
            out.print("Hello, " + mail + "  Welcome to ur Profile");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
%>