<%@ page import="java.sql.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp"%>
<%@include file="includes/session.jsp" %>

<%
    String nom = (String) request.getAttribute("nom");
    String prenom = (String) request.getAttribute("prenom");
    String vmail = (String) request.getAttribute("mail");
    String telephone = (String) request.getAttribute("telephone");
    String birthday = (String) request.getAttribute("birthday");
    String password = (String) request.getAttribute("password");
%>
<div class="text-center">
    <ul>
        <li>Nom : <%= nom %>
        </li>
        <li>Prénom : <%= prenom %>
        </li>
        <li>Mail : <%= vmail %>
        </li>
        <li>Téléphone : <%= telephone %>
        </li>
        <li>Date de naissance : <%= birthday %>
        </li>
        <li>Mot de Passe : <%= password %>
        </li>
    </ul>
</div>
</body>
</html>
