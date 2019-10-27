<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vue Inscription</title>
</head>
<body>
<%
    String nom = (String) request.getAttribute("nom");
    String mail = (String) request.getAttribute("mail");
    String password = (String) request.getAttribute("password");
    out.println("Nom : " + nom);
    out.println("Mail : " + mail);
    out.println("Mdp : " + password);
%>
</body>
</html>
