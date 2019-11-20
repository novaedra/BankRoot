<%@ page import="com.models.Clients" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/session.jsp" %>
<%@include file="includes/navbar.jsp" %>

<div onloadstart="note()" class="liste">
    <h2>Liste Clients</h2>
    <ul>
        <%
            List<Clients> clients = (List<Clients>) request.getAttribute("resultat");
            int pagination = 2;
            int offset = pagination *10;
            int compteur = 0;
            for (Clients client : clients) {
                compteur++;
                if (compteur >= offset-10) {
                    out.println("<li>" + client.getPrenom() + " " + client.getNom() + " <span id='note'>" + client.getNoteEp() + "</span></li>");
                }
                if (compteur == offset) {break;}
            }
        %>
    </ul>
</div>

<script type="text/javascript" src="assets/js/script.js"></script>
<script type="text/javascript">window.onload = note();</script>
<%@include file="includes/footer.jsp" %>
