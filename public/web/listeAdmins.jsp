<%@ page import="java.util.*" %>
<%@ page import="com.models.Admins" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/session.jsp" %>
<%@include file="includes/navbar.jsp" %>

<%
    /*  Seuls les admins avec le role supAdmin peuvent accéder au contenu de cette page.
     */
    if (session != null) {
        if (session.getAttribute("role").equals("supAdmin")) {

%>
<h1>Mes Admins</h1>
<table>
    <thead>
    <th>Nom</th>
    <th>Prénom</th>
    <th></th>
    </thead>
    <tbody>
    <%
        List<Admins> admins = (List<Admins>) request.getAttribute("resultat");
        for (Admins admin : admins) {
            out.println("<tr><td>" + admin.getNom() + "</td>&nbsp;<td>" + admin.getPrenom() + "</td>" + "<td><a href='DetailsAdmins?id=" + admin.getId() + "'>Détails</a></td></tr>");

        }
    %>
    </tbody>
</table>


<%@include file="includes/footer.jsp" %>
<% } else {
    /* S'ils ne sont qu'admin, ils sont redirigés vers le dashboard. */
    response.sendRedirect("dashboard.jsp");
}

}
%>

<%@include file="includes/footer.jsp" %>