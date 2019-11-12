<%@ page import="com.models.Clients" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/session.jsp" %>
<%@include file="includes/navbar.jsp" %>


<div class="dropdown">
    <button onclick="showClientList()" class="dropbtn"><img id="menuDeroulant" alt="icône menu déroulant"
                                                            src="assets/img/menu_dropdown.svg"/></button>

    <div id="dropdown-content" style="display: none;">
        <%
            List<Clients> clients = (List<Clients>) request.getAttribute("resultat");
            for (Clients client : clients) {
                out.println("<a class='btnClient' onclick='showClientDetail(" + client.getId() + ")'>" + client.getPrenom() + " " + client.getNom() + "</a>");
            }
        %>
    </div>
</div>

<%
    List<Clients> clientsModal = (List<Clients>) request.getAttribute("resultat");
    for (Clients clientModal : clientsModal) {
        out.println("<div id=" + clientModal.getId() + " class='liste'>" +
                "<ul><li>" + "Nom : " + clientModal.getNom() + "</li>" + "<li>" + "Prenom : " + clientModal.getPrenom() + "</li>"
                + "<li>" + "Mail : " + clientModal.getMail() + "</li>" + "<li>" + "Date de naissance : " + clientModal.getBirthday() + "</li>"
                + "<li>" + "Nombre d'enfants : " + clientModal.getEnfacharges() + "</li>" + "<li>"
                + "Adresse postale : " + clientModal.getAdresse() + "</li>" + "<li>" + "Prospect : " + clientModal.isProspect() + "</li>" + "<li>" +
                "Autorisation CNIL : " + clientModal.isAutoCnil() + "</li>" + "<li>" + "Revenus mensuels : " + clientModal.getRevenus() + "</li>" +
                "<li>" + "Dépenses mensuelles : " + clientModal.getDepenses() + "</li>" + "<li>" + "Situation professionelle : " + clientModal.getSitutationpro() + "</li>" +
                "<li>" + "Situation matrimoniale : " + clientModal.getStatutmatri() + "</li>" +
                "</ul><button onclick='closeClientDetail(" + clientModal.getId() + ")'>Fermer</button></div>");
    }
%>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/script.js"></script>
<%@include file="includes/footer.jsp" %>
