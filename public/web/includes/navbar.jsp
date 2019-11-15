<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    /* On récupére les valeurs en session */
    String _prenom = (String) session.getAttribute("prenom");
    String _nom = (String) session.getAttribute("nom");
%>
<nav id="navbar">
    <ul>
        <li><a href="Dashboard">Bonjour <%= _prenom + " " + _nom%><img src="assets/img/avatar.svg" alt="icone profil"/></a></li>
        <li><a href="Message">Messages <img src="assets/img/email.svg" alt="icone mail"/></a></li>
        <li><a href="Reglages">Reglages<img src="assets/img/settings.svg" alt="icone paramètre"/></a></li>
        <% if (session.getAttribute("role").equals("supAdmin")) { %>
        <li><a href="Liste-Admins">Liste des Admins<img src="assets/img/admin.svg" alt="icone administrateur"/></a></li>
        <li><a href="Ajout-Admin">Ajout d'un Admin<img src="assets/img/plus.svg" alt="icone profil"/></a></li>
        <% } %>
        <li><a href="Logout">Déconnexion&nbsp;<img src="assets/img/logout.svg" alt="icone déconnexion"/></a></li>
    </ul>
</nav>