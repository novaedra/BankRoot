<%@ page import="java.util.*" %>
<%@ page import="com.models.Admins" %>
<%@ page import="com.models.Conditions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/session.jsp" %>
<%@include file="includes/navbar.jsp" %>

<%
    /*  Seuls les admins avec le role supAdmin peuvent accéder au contenu de cette page.
     */

    if (session.getAttribute("role").equals("supAdmin")) {

%>
<div class="liste">
    <h2>Liste des Conditions</h2>
    <ul>
        <%
            List<Conditions> conditions = (List<Conditions>) request.getAttribute("resultat");
            for (Conditions condition : conditions) {
                out.println("<li class='admin'>" + condition.getNom() + ": " + condition.getArgument() + " " + condition.getOperateur()
                        + " " + condition.getValeur() + "</li>");

        %>


        <%@include file="includes/footer.jsp" %>
        <%
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/Dashboard");
            }

        %>
        <a class="new" href="Ajout-Condition"> Ajouter une condition<img src="assets/img/plus.svg" alt="icone nouveau"/></a>
    </ul>
</div>

<%@include file="includes/footer.jsp" %>