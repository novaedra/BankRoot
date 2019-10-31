<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<form class="justify-content-center" method="post" action="Inscription">
    <img src="assets/img/BankRoot.svg" alt="logo bankroot"><br/>
    <input class="form-control" type="text" name="nom" placeholder="Nom">
    <input class="form-control" type="text" name="prenom" placeholder="Prénom">
    <input class="form-control" type="text" name="ident" placeholder="Identifiant">
    <input class="form-control" type="text" name="mail" placeholder="Adresse Mail">
    <input class="form-control" type="text" name="telephone" placeholder="Téléphone">
    <input class="form-control" type="date" name="birthday" placeholder="Date de naissance">
    <input class="form-control" type="text" name="adresse" placeholder="Adresse">
    <input class="form-control" type="password" name="password" placeholder="Mot de Passe">
    <button class="btn btn-success my-4 btn-block" type="submit">Ajouter</button>
</form>
<%@include file="includes/footer.jsp" %>
