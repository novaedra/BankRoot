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

<form id="formAnimation" class="detailAnimation" action="DetailsAdmins" method="post" accept-charset="ISO-8859-1">
    <h2>Informations admins</h2><br/>

    <input type="hidden" value="<%= admin.getId()%>" name="id" readonly>
    <input type="hidden" value="<%= admin.getPassword()%>" name="hash" readonly>
    <input onclick="change()" type="text" value="<%= admin.getNom()%>" name="nom" readonly>
    <input onclick="change()" type="text" value="<%= admin.getPrenom()%>" name="prenom" readonly>
    <input onclick="change()" type="text" value="<%= admin.getMail()%>" name="mail" readonly>
    <input onclick="change()" type="text" value="<%= admin.getTelephone()%>" name="telephone" readonly>
    <% if (session.getAttribute("role").equals("supAdmin")) { %>
    <input onclick="change()" type="text" value="<%= admin.getRole()%>" name="role" readonly>
    <% }%>
    <input onclick="change()" type="date" value="<%= admin.getBirthday()%>" name="birthday" readonly><br/>
    <input id="validation" type="submit" value="Mettre à jour" style="display: none" disabled>

</form>
<% }
%>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/script.js"></script>
<%@include file="includes/footer.jsp" %>


