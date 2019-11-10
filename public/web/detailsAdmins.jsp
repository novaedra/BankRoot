<%@ page import="java.util.List" %>
<%@ page import="com.models.Admins" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/session.jsp" %>
<%@include file="includes/navbar.jsp" %>

<%
    List<Admins> admins = (List<Admins>) request.getAttribute("resultat");

    for (Admins admin : admins) {
%>
<a href=""><%=admin.getPrenom() + " " + admin.getNom() + " " + admin.getMail() %>
</a>
<% }
%>


<%@include file="includes/footer.jsp" %>


