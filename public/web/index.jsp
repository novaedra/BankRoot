<%@ page import="webappli.models.Admins" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%
    String mail = (String) session.getAttribute("mail");
    if (mail == null) {
        response.sendRedirect("login.jsp");
    } else {
%>
<h1>Hello</h1>
<%@include file="includes/footer.jsp" %>
<% } %>