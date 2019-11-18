<%@ page import="java.util.*" %>
<%@ page import="com.models.Admins" %>
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
    <h2>Mes Admins</h2>
    <ul>
        <%
            List<Admins> admins = (List<Admins>) request.getAttribute("resultat");
            for (Admins admin : admins) {
                out.println("<li class='admin'><a class='detail' href='DetailsAdmins?id=" + admin.getId() + "'>"+ admin.getNom() + " " + admin.getPrenom());
                String test = admin.getRole();
                if (test.equals("supAdmin")) { out.println("<img src=\"assets/img/admin.svg\" alt=\"icone administrateur\"/>"); }
                out.println("</a></li>");

            }
        %>
        <a class="new" href="Ajout-Admin"> Ajouter un admin<img src="assets/img/plus.svg" alt="icone nouveau"/></a>
    </ul>
</div>

<%@include file="includes/footer.jsp" %>
<% } else {
    /* S'ils ne sont qu'admin, ils sont redirigés vers le dashboard. */
    response.sendRedirect("Dashboard");

}
%>

<%@include file="includes/footer.jsp" %>