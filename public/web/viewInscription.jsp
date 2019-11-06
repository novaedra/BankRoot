<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/navbar.jsp" %>
<%@include file="includes/session.jsp" %>
<%
    String nom = (String) request.getAttribute("nom");
    String prenom = (String) request.getAttribute("prenom");
    String mail = (String) request.getAttribute("mail");
    String telephone = (String) request.getAttribute("telephone");
    String birthday = (String) request.getAttribute("birthday");
    String password = (String) request.getAttribute("password");
%>
<div class="liste">
    <img src="assets/img/BankRoot.svg" alt="logo bankroot"><br/>
    <ul>
        <li>Nom : <%= nom %>
        </li>
        <li>Prénom : <%= prenom %>
        </li>
        <li>Mail : <%= mail %>
        </li>
        <li>Téléphone : <%= telephone %>
        </li>
        <li>Date de naissance : <%= birthday %>
        </li>
        <li>Mot de Passe : <%= password %>
        </li>
    </ul>
</div>
<%@include file="includes/footer.jsp" %>
