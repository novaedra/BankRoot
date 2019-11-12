<%@ page import="java.util.List" %>
<%@ page import="com.models.Admins" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/session.jsp" %>
<%@include file="includes/navbar.jsp" %>

<%
    List<Admins> admins = (List<Admins>) request.getAttribute("resultat");
%>

<%
    for (Admins admin : admins) {
%>
<p>Ajouté le : <%=admin.getCreated_at()%>
</p>
<p>Dernière modification le : <%=admin.getUpdated_at()%>
</p>
<form action="DetailsAdmins" method="post">


    <input type="hidden" value="<%= admin.getId()%>" name="id">
    <input type="hidden" value="<%= admin.getPassword()%>" name="hash">
    <input type="text" value="<%= admin.getNom()%>" name="nom">
    <input type="text" value="<%= admin.getPrenom()%>" name="prenom">
    <input type="text" value="<%= admin.getMail()%>" name="mail">
    <input type="text" value="<%= admin.getTelephone()%>" name="telephone">
    <input type="text" value="<%= admin.getRole()%>" name="role">
    <input type="date" value="<%= admin.getBirthday()%>" name="birthday">

    <input type="submit" value="Mettre à jour">
</form>
<% }
%>


<%@include file="includes/footer.jsp" %>


