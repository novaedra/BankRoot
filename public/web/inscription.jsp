<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/navbar.jsp" %>
<%@include file="includes/session.jsp" %>
<%
    /*  Seuls les admins avec le role supAdmin peuvent accéder au contenu de cette page.
     */
    if (session != null) {
        if (session.getAttribute("role").equals("supAdmin")) {

%>


<form method="post" action="Inscription">
    <img src="assets/img/BankRoot.svg" alt="logo bankroot"><br/>

    <input class="form-control" type="text" id=nom name="nom" placeholder="Nom (*)"
           value="<c:out value="${admins.nom}"/>"><br/>
    <span>${form.erreurs['nom']}</span><br/>
    <input class="form-control" type="text" id="prenom" name="prenom" placeholder="Prénom (*)"
           value="<c:out value="${admins.prenom}"/>"><br/>
    <span>${form.erreurs['prenom']}</span><br/>
    <input class="form-control" type="text" id="mail" name="mail" placeholder="Adresse Mail (*)"
           value="<c:out value="${admins.mail}"/>"><br/>
    <span>${form.erreurs['mail']}</span><br/>
    <input class="form-control" id="telephone" type="text" name="telephone" placeholder="Téléphone (*)"
           value="<c:out value="${admins.telephone}"/>"><br/>
    <span>${form.erreurs['telephone']}</span><br/>
    <input class="form-control" type="date" id="birthday" name="birthday" placeholder="Date de naissance (*)"
           value="<c:out value="${admins.birthday}"/>"><br/>
    <span>${form.erreurs['birthday']}</span><br/>
    <div class="radio">
        <label for="admin">Administrateur (*)</label>
        <input type="radio" id="admin" name="role" value="admin" checked>
        <span>${form.erreurs['role']}</span><br/>
        <label for="supadmin">Super Administrateur</label>
        <input type="radio" id="supadmin" name="role" value="supAdmin">
        <span>${form.erreurs['role']}</span><br/>
    </div>
    <input class="form-control" id="password" type="password" name="password" placeholder="Mot de Passe (*)"
           value="<c:out value="${admins.password}"/>"><br/>
    <span>${form.erreurs['password']}</span><br/>
    <button class="btn btn-success my-4 btn-block" type="submit">Ajouter</button>

</form>
<%@include file="includes/footer.jsp" %>
<% } else {
    /* S'ils ne sont qu'admin, ils sont redirigés vers le dashboard. */
    response.sendRedirect("dashboard.jsp");
}

}
%>