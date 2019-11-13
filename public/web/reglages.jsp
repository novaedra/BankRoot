<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/session.jsp" %>
<%@include file="includes/navbar.jsp" %>

<form action="UpdatePassword" method="post">
    <h2>Changement de mot de passe</h2><br/>
    <input type="password" name="oldPassword" placeholder="Votre mot de passe actuel">
    <input type="password" name="newPassword" placeholder="Nouveau mot de passe">
    <input type="password" name="newConfirmation" placeholder="Confirmer le nouveau mot de passe">
    <input type="submit" value="Changer">
</form>

<!--
<a href="doubleAuthentification.jsp">
<h1>Activer la double Authentification</h1>
</a>
-->

<%@include file="includes/footer.jsp" %>