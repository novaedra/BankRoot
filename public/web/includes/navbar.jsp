<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    /* On récupére les valeurs en session */
    String _prenom = (String) session.getAttribute("prenom");
    String _nom = (String) session.getAttribute("nom");

%>
<nav id="navbar">
    <ul>
        <li><a href="Dashboard">Bonjour <%= _prenom + " " + _nom%>&nbsp; <img
                src="assets/img/avatar.svg"
                alt="icone profil"/></a></li>
        <li><a href="#">Messages <img src="assets/img/email.svg" alt="icone mail"/></a></li>
        <li><a href="reglages.jsp">Reglages<img src="assets/img/settings.svg" alt="icone paramètre"/></a></li>
        <li><a href="Logout">Déconnexion&nbsp;<img src="assets/img/logout.svg" alt="icone déconnexion"/></a></li>
        <% if (session.getAttribute("role").equals("supAdmin")) { %>
        <li><a href="Liste-Admins">Liste des Admins</a></li>
        <li><a href="Inscription">Ajout d'un Admin</a></li>
        <% } %>
    </ul>
</nav>