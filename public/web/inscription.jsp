<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.jsp" %>
<form method="post" action="Inscription">
    <input type="text" name="nom" placeholder="Nom">
    <input type="email" name="mail" placeholder="Adresse Mail">
    <input type="password" name="password" placeholder="Mot de Passe">
    <button type="submit">Ajouter</button>
</form>
<%@include file="includes/footer.jsp" %>
