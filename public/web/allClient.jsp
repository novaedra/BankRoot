<%@ page import="com.models.Clients" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/session.jsp" %>
<%@include file="includes/navbar.jsp" %>

<div class="liste">
    <h2>Liste Clients</h2>
    <ul>
        <%
            List<Clients> clients = (List<Clients>) request.getAttribute("resultat");
            Integer pagination = (Integer) request.getAttribute("pagination"); //probleme ici entre pagination appeler et pagination en int
            int offset = pagination * 10;
            int compteur = 1;
            int page_suivante = pagination + 1;
            int page_precedente = pagination - 1;
            int page_max = clients.size()/10+1;
            for (Clients client : clients) {
                if (compteur >= offset - 9) {
                    out.println("<a><li>" + client.getPrenom() + " " + client.getNom() + " <span id='note'>" + client.getNoteEp() + "</span></li></a>");
                }
                if (compteur == offset) {
                    break;
                }
                compteur++;
            }
        %>
    </ul>
    <div class="pagination">
        <% if (pagination > 1) {
            out.println("<a href='allClient?page=" + page_precedente + "'><img class='imgpagination' src='assets/img/arrowleft.svg' alt='icone précédant'/> Page " + page_precedente + "</a>");
        }
            out.println("<a class='active' href='allClient?page=" + pagination + "'>" + pagination + "</a>");
            if (pagination < Math.round(page_max)) {
            out.println("<a href='allClient?page=" + page_suivante + "'>Page " + page_suivante + " <img class='imgpagination' src='assets/img/arrowright.svg' alt='icone suivant'/></a>");
        } else if (pagination > Math.round(page_max)){
            response.sendRedirect("allClient?page=" + Math.round(page_max));
        } %>
    </div>
</div>

<script type="text/javascript" src="assets/js/script.js"></script>
<script type="text/javascript">window.onload = note();</script>
<%@include file="includes/footer.jsp" %>
