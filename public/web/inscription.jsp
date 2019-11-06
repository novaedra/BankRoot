<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/head.jsp" %>
<%@include file="includes/session.jsp" %>

<form class="justify-content-center" method="post" action="Inscription">
    <div class="form-row mb-4">
        <div class="">
            <input class="form-control" type="text" name="nom" placeholder="Nom" required="required">
        </div>
        <div class="">
            <input class="form-control" type="text" name="prenom" placeholder="Prénom" required="required">
        </div>
        <div class="">
            <input class="form-control" type="text" name="mail" placeholder="Adresse Mail" required="required">
        </div>
        <div class="">
            <input class="form-control" type="text" name="telephone" placeholder="Téléphone" required="required">
        </div>
        <div>
            <input class="form-control" type="date" name="birthday" placeholder="Date de naissance" required="required">
        </div>
        <div>
            <label for="supAdmin">Choisissez un rôle :</label>
            <select name="supAdmin" id="supAdmin">
                <option value="0">Administrateur</option>
                <option value="1">Super Administrateur</option>
            </select>
        </div>
        <div class="">
            <input class="form-control" type="password" name="password" placeholder="Mot de Passe" required="required">
        </div>
        <button class="btn btn-success my-4 btn-block" type="submit">Ajouter</button>
    </div>
</form>
<%@include file="includes/footer.jsp" %>
