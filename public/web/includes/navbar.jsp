<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    /* On récupére les valeurs en session */
    String _prenom = (String) session.getAttribute("prenom");
    String _nom = (String) session.getAttribute("nom");
%>
<nav id="navbar">
    <ul>
        <li><a href="Dashboard">Mes clients </a></li>
        <li><a href="Message">Mail <img src="assets/img/email.svg" alt="icone mail"/></a></li>
        <% if (session.getAttribute("role").equals("supAdmin")) { %>
        <li><a href="Liste-Admins">Liste des admins</a></li>
        <li><a href="Liste-Produits">Liste des produits</a></li>
        <% } %>
        <li><a href="Reglages"><%= _prenom + " " + _nom%><img src="assets/img/settings.svg" alt="icone paramètre"/></a></li>
        <li><a href="Logout">Déconnexion&nbsp;<img src="assets/img/logout.svg" alt="icone déconnexion"/></a></li>
    </ul>
</nav>