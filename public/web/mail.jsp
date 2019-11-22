<%@ page import="com.models.Produits" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/session.jsp" %>
<%@include file="includes/navbar.jsp" %>

<%

    String destinataire = (String) request.getAttribute("destinataire");
    String nom = (String) request.getAttribute("nom");
    String des = (String) request.getAttribute("des");

    if (destinataire == null) {
        destinataire = "client@gmail.com";
    }
%>

<form action="SendMail" method="post">
    <img src="assets/img/BankRoot.svg" alt="logo bankroot"><br/>
    <label for="to">Destinataire :</label><br/>
    <input type="email" id="to" name="to" placeholder="Mail" value="<%=(destinataire) %>"/><br/>
    <label for="subject">Sujet :</label><br/>
    <input type="text" id="subject" name="subject" placeholder="Offre de création de compte" value="<%= (nom)%>"/><br/>
    <label for="content">Message :</label><br/>
    <textarea id="content" name="content" cols="70" rows="5"><%=(des)%></textarea><br/>
    <input type="submit" value="Envoyer"/>
</form>


<%@include file="includes/footer.jsp" %>