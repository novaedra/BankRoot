<%@ page import="java.util.List" %>
<%@ page import="com.models.Admins" %>
<%@ page import="com.utils.controllers.GenOffer" %>
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

<form action="DetailsAdmins" method="post" accept-charset="ISO-8859-1">
    <h2>Informations admins</h2><br/>
    <input type="hidden" value="<%= admin.getId()%>" name="id">
    <input type="hidden" value="<%= admin.getPassword()%>" name="hash">
    <input type="text" value="<%= admin.getNom()%>" name="nom">
    <input type="text" value="<%= admin.getPrenom()%>" name="prenom">
    <input type="text" value="<%= admin.getMail()%>" name="mail">
    <input type="text" value="<%= admin.getTelephone()%>" name="telephone">
    <input type="text" value="<%= admin.getRole()%>" name="role">
    <input type="date" value="<%= admin.getBirthday()%>" name="birthday"><br/>
    <span>Admin ajouté le : <%=admin.getCreated_at()%></span><br/>
    <span>Information modifié le : <%=admin.getUpdated_at()%></span><br/>

    <input type="submit" value="Mettre à jour">
</form>
<% }
%>


<%@include file="includes/footer.jsp" %>


