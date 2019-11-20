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
            int compteur = 0;
            for (Clients client : clients) {
                compteur++;
                if (compteur == 10) {break;}
                out.println("<a class='btnClient' onclick=" + "\"" + "showClientDetail('client" + client.getId() + "')"
                        + "\"" + ">" + client.getPrenom() + " " + client.getNom() + "</a>");
            }
        %>
        <% if (session.getAttribute("role").equals("supAdmin")) { %>
        <a class="btnClient seeall" href="allClient?pagination=1">Voir tout les clients</a>
        <% } %>
    </div>
</div>

<%
    List<Clients> clientsModal = (List<Clients>) request.getAttribute("resultat");
    compteur = 0;
    for (Clients clientModal : clientsModal) {
        compteur++;
        if (compteur == 10) {break;}
        out.println("<div id='client" + clientModal.getId() + "' class='liste' style='display:none'>" + "<h2>" + clientModal.getPrenom() + " " + clientModal.getNom() + " " + "<span id='note'>" + clientModal.getNoteEp() + "</span>" + "</h2>"
                + "<ul>" + "<li>" + "Mail : " + clientModal.getMail() + "</li>" + "<li>" + "Date de naissance : " + clientModal.getBirthday() + "</li>"
                + "<li>" + "&Acirc;ge : " + Math.round(clientModal.getAge()) + "</li>"
                + "<li>" + "Nombre d'enfants : " + clientModal.getEnfacharges() + "</li>" + "<li>"
                + "Adresse postale : " + clientModal.getAdresse() + "</li>" + "<li>" + "Prospect : " + clientModal.getProspect() + "</li>" + "<li>" +
                "Autorisation CNIL : " + clientModal.getAutoriCnil() + "</li>" + "<li>" + "Revenus annuels : " + clientModal.getRevenus() + "</li>" +
                "<li>" + "Dépenses annuelles : " + clientModal.getDepenses() + "</li>" + "<li>" + "Situation professionelle : " + clientModal.getStatPro() + "</li>" +
                "<li>" + "Situation matrimoniale : " + clientModal.getStatutmatri() + "</li>" +
                "</ul><button onclick=" + "\"" + "closeClientDetail('client" + clientModal.getId() + "')" + "\"" + ">Fermer</button></div>");
    }
%>


<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/script.js"></script>
<%@include file="includes/footer.jsp" %>
