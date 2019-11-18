<%@ page import="java.util.List" %>
<%@ page import="com.models.Admins" %>
<%@ page import="com.models.Produits" %>
<%@ page import="com.models.Categories" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/session.jsp" %>
<%@include file="includes/navbar.jsp" %>

<%
    List<Produits> produits = (List<Produits>) request.getAttribute("resultat");
%>

<%
    for (Produits produit : produits) {
%>

<form action="DetailsProduits" method="post" accept-charset="ISO-8859-1">
    <h2>Informations produit</h2><br/>
    <select name="categorie_id">
        <option>Catégorie</option>
        <%
            @SuppressWarnings("unchecked")
            List<Categories> categories = (List<Categories>) request.getAttribute("categories");

            if (categories != null) {
                for (Categories categorie : categories) {
        %>
        <option value="<%= categorie.getId_categorie() %>"><%= categorie.getNom() %>
        </option>
        <%
                }
            }
        %>
    </select><br>
    <input type="hidden" value="<%= produit.getId()%>" name="id_prod">
    <input type="text" value="<%= produit.getNom()%>" name="nom">
    <input type="text" value="<%= produit.getTaux()%>" name="taux">
    <input type="text" value="<%= produit.getFrais()%>" name="frais"><br/>
    <textarea name="description" cols="30" rows="10"><%= produit.getDescription()%></textarea><br/>
    <span>Produit ajouté le : <%=produit.getCreated_at()%></span><br/>
    <span>Information modifié le : <%=produit.getUpdated_at()%></span><br/>

    <input type="submit" value="Mettre à jour">
</form>
<% }
%>


<%@include file="includes/footer.jsp" %>


