<%@ page import="java.util.*" %>
<%@ page import="webappli.models.Admins" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/session.jsp" %>
<h1>Mes Admins</h1>
<%
    List<Admins> admins = (List<Admins>) request.getAttribute("resultat");
%>
<table>
    <%
        if (admins != null) {
            for (Admins admin : admins) {

    %>
    <tbody>
    <tr>
        <th><%=admin.getNom()%>
        </th>
        <th><%=admin.getPrenom()%>
        </th>
        <th><%=admin.getMail()%>
        </th>
    </tr>
    </tbody>
    <%
            }
        } else {

            out.println("Vous ne disposez pas des droits nécessaires pour obtenir ces informations.");
        }
    %>
</table>
<%@include file="includes/footer.jsp" %>