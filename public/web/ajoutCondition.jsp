<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/session.jsp" %>
<%@include file="includes/navbar.jsp" %>

<form action="Ajout-Condition" method="post" accept-charset="ISO-8859-1">
    <input type="text" name="nom" placeholder="Nom">
    <input type="text" name="argument" placeholder="age, revenu, ...">
    <%--    <input type="text" name="operateur" placeholder="Opérateur">--%>
    <select name="operateur">
        <option value="&lt;">Inférieur à</option>
        <option value="&lt;=">Inférieur ou égal à</option>
        <option value="&gt;">Supérieur à</option>
        <option value="=&gt;">Supérieur ou égal à</option>
        <option value="=">&Eacute;gal à</option>
        <option value="&ne;">Différent de</option>
    </select>
    <input type="text"  name="valeur" placeholder="Valeur">
    <input type="submit" value="Ajouter">
</form>

<%@include file="includes/footer.jsp" %>