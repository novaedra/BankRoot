<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/session.jsp" %>

<h1>Changement de mot de passe</h1>
<form action="UpdateAtA" method="post">
    <input type="password" name="oldPassword" placeholder="Votre mot de passe actuel">
    <input type="password" name="newPassword" placeholder="Nouveau mot de passe">
    <input type="password" name="newConfirmation" placeholder="Confirmer le nouveau mot de passe">
    <input type="submit" value="Changer">
</form>


<%@include file="includes/footer.jsp" %>