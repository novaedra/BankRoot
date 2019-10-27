<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vue Inscription</title>
</head>
<body>
<%
    String nom = (String) request.getAttribute("nom");
    String mail = (String) request.getAttribute("mail");
    out.println("Nom : " + nom);
    out.println("Mail : " + mail);
%>
</body>
</html>
