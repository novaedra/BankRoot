<%@ page import="java.sql.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vue Inscription</title>
</head>
<body>
<%
    String nom = (String) request.getAttribute("nom");
    String prenom = (String) request.getAttribute("prenom");
    String ident = (String) request.getAttribute("ident");
    String mail = (String) request.getAttribute("mail");
    String telephone = (String) request.getAttribute("telephone");
    String birthday = (String) request.getAttribute("birthday");
    String adresse = (String) request.getAttribute("adresse");
    String password = (String) request.getAttribute("password");
%>
<div class="text-center">
    <ul>
        <li>Nom : <%= nom %>
        </li>
        <li>Prénom : <%= prenom %>
        </li>
        <li>Identifiant : <%= ident%>
        </li>
        <li>Mail : <%= mail %>
        </li>
        <li>Téléphone : <%= telephone %>
        </li>
        <li>Date de naissance : <%= birthday %>
        </li>
        <li>Adresse : <%= adresse %>
        </li>
        <li>Mot de Passe : <%= password %>
        </li>
    </ul>
</div>
</body>
</html>
