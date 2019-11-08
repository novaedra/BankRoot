
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (session != null) {
        if (session.getAttribute("mail") != null) {
            String mail = (String) session.getAttribute("mail");
            String role = (String) session.getAttribute("role");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
%>