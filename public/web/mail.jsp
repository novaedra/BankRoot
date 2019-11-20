<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/session.jsp" %>
<%@include file="includes/navbar.jsp" %>


<form action="SendMail" method="post">
    <img src="assets/img/BankRoot.svg" alt="logo bankroot"><br/>
    <label for="to">Destinataire :</label><br/>
    <input type="email" id="to" name="to" placeholder="michel@gmail.com"/><br/>
    <label for="subject">Sujet :</label><br/>
    <input type="text" id="subject" name="subject" placeholder="Offre de création de compte"/><br/>
    <label for="content">Message :</label><br/>
    <textarea id="content" name="content" id="" cols="70" rows="5"></textarea><br/>
    <input type="submit" value="Envoyer"/>
</form>

<%@include file="includes/footer.jsp" %>