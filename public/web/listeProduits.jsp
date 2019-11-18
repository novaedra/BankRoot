<%@ page import="com.models.Produits" %>
<%@ page import="java.util.List" %>
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
    <h2>Nos Produits</h2>
    <ul>
        <%
            List<Produits> produits = (List<Produits>) request.getAttribute("resultat");
            for (Produits produit : produits) {
                out.println("<li class='admin'><a class='detail' href='DetailsProduits?id_prod=" + produit.getId() + "'>" + produit.getNom() + "</a></li>");

            }
        %>
    </ul>
</div>

<%@include file="includes/footer.jsp" %>
<% } else {
    /* S'ils ne sont qu'admin, ils sont redirigés vers le dashboard. */
    response.sendRedirect("Dashboard");

}
%>


<%@include file="includes/footer.jsp" %>