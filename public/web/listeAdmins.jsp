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
<div class="liste">
    <h2>Mes Admins</h2>
    <ul>
        <%
            List<Admins> admins = (List<Admins>) request.getAttribute("resultat");
            for (Admins admin : admins) {
                out.println("<li class='admin'><a class='detail' href='DetailsAdmins?id=" + admin.getId() + "'>"+ admin.getNom() + " " + admin.getPrenom() + " " + admin.getRole() + "</a></li>");

            }
        %>
    </ul>
</div>

<%@include file="includes/footer.jsp" %>
<% } else {
    /* S'ils ne sont qu'admin, ils sont redirigés vers le dashboard. */
    response.sendRedirect("dashboard.jsp");
}

}
%>

<%@include file="includes/footer.jsp" %>