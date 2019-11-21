<%@ page import="com.models.Clients" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/session.jsp" %>
<%@include file="includes/navbar.jsp" %>

<%
    out.println("<div id='client" + clientModal.getId() + "' class='liste' style='display:none'>" + "<h2>" + clientModal.getPrenom() + " " + clientModal.getNom() + " " + "<span id='note'>" + clientModal.getNoteEp() + "</span>" + "</h2>"
            + "<ul>" + "<li>" + "Mail : " + clientModal.getMail() + "</li>" + "<li>" + "Date de naissance : " + clientModal.getBirthday() + "</li>"
            + "<li>" + "&Acirc;ge : " + Math.round(clientModal.getAge()) + "</li>"
            + "<li>" + "Nombre d'enfants : " + clientModal.getEnfacharges() + "</li>" + "<li>"
            + "Adresse postale : " + clientModal.getAdresse() + "</li>" + "<li>" + "Prospect : " + clientModal.getProspect() + "</li>" + "<li>" +
            "Autorisation CNIL : " + clientModal.getAutoriCnil() + "</li>" + "<li>" + "Revenus annuels : " + clientModal.getRevenus() + "</li>" +
            "<li>" + "Dépenses annuelles : " + clientModal.getDepenses() + "</li>" + "<li>" + "Situation professionelle : " + clientModal.getStatPro() + "</li>" +
            "<li>" + "Situation matrimoniale : " + clientModal.getStatutmatri() + "</li>" +
            "</ul><button onclick=" + "\"" + "closeClientDetail('client" + clientModal.getId() + "')" + "\"" + ">Fermer</button></div>");
%>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/script.js"></script>
<%@include file="includes/footer.jsp" %>


