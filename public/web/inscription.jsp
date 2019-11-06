<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/session.jsp" %>

<% if (session != null) {
    String supAdmin = "supAdmin";
    if (session.getAttribute("role") == supAdmin) {
%>

<form method="post" action="Inscription">
    <img src="assets/img/BankRoot.svg" alt="logo bankroot"><br/>
    <input class="form-control" type="text" name="nom" placeholder="Nom">
    <input class="form-control" type="text" name="prenom" placeholder="Prénom">
    <input class="form-control" type="text" name="mail" placeholder="Adresse Mail">
    <input class="form-control" type="text" name="telephone" placeholder="Téléphone">
    <input class="form-control" type="date" name="birthday" placeholder="Date de naissance">
    <label for="admin">Administrateur</label>
    <input type="radio" id="admin" name="role" value="admin" checked>
    <label for="supadmin">Super Administrateur</label>
    <input type="radio" id="supadmin" name="role" value="supAdmin" checked>
    <input class="form-control" type="password" name="password" placeholder="Mot de Passe">
    <button class="btn btn-success my-4 btn-block" type="submit">Ajouter</button>
</form>
<%@include file="includes/footer.jsp" %>
<% } else {
    response.sendRedirect("dashboard.jsp");
}
}
%>