<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/session.jsp" %>

<form class="justify-content-center" method="post" action="Inscription">
    <div class="form-row mb-4">
        <div class="">
            <input class="form-control" type="text" name="nom" placeholder="Nom">
        </div>
        <div class="">
            <input class="form-control" type="text" name="prenom" placeholder="Prénom">
        </div>
        <div class="">
            <input class="form-control" type="text" name="mail" placeholder="Adresse Mail">
        </div>
        <div class="">
            <input class="form-control" type="text" name="telephone" placeholder="Téléphone">
        </div>
        <div>
            <input class="form-control" type="date" name="birthday" placeholder="Date de naissance">
        </div>
        <div class="">
            <input class="form-control" type="password" name="password" placeholder="Mot de Passe">
        </div>
        <button class="btn btn-success my-4 btn-block" type="submit">Ajouter</button>
    </div>
</form>
<%@include file="includes/footer.jsp" %>
