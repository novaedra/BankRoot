<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vue Inscription</title>
</head>
<body>
<%
    String nom = (String) request.getAttribute("nom");
    String prenom = (String) request.getAttribute("prenom");
    String mail = (String) request.getAttribute("mail");
    String telephone = (String) request.getAttribute("telephone");
    String password = (String) request.getAttribute("password");
%>
<div class="text-center">
    <ul>
        <li>Nom : <%= nom %>
        </li>
        <li>Prénom : <%= prenom %>
        </li>
        <li>Mail : <%= mail %>
        </li>
        <li>Téléphone : <%= telephone %>
        </li>
        <li>Mot de Passe : <%= password %>
        </li>
    </ul>
</div>
</body>
</html>
