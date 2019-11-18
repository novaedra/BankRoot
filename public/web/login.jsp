<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<form action="Login" class="login" method="post">
    <img src="assets/img/BankRoot.svg" alt="logo bankroot"><br/>
    <input type="email" name="mail" placeholder="Adresse Mail">
    <input type="password" name="password" placeholder="Mot de Passe">
    <button type="submit">Connexion</button>
</form>
<%@include file="includes/footer.jsp" %>