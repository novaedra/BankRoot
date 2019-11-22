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


<form id="formAnimation" class="detailAnimation" action="DetailsProduits" method="post" accept-charset="ISO-8859-1">

    <h2>Informations produit</h2><br/>
    <select onfocus="change()" name="categorie_id">
        <%
            @SuppressWarnings("unchecked")
            List<Categories> categories = (List<Categories>) request.getAttribute("categories");

            if (categories != null) {
                for (Categories categorie : categories) {
        %>
        <option value="<%= categorie.getId_categorie() %>" <% if (produit.getId_categorie().equals(categorie.getId_categorie())){ out.println("selected"); } %>>
        <%= categorie.getNom() %>
        </option>
        <%
                }
            }
        %>
    </select><br>
    <input type="hidden" value="<%= produit.getId()%>" name="id_prod">

    <input onclick="change()" type="text" value="<%= produit.getNom()%>" name="nom" readonly>
    <input onclick="change()" type="text" value="<%= produit.getTaux()%>" name="taux" readonly>

    <input onclick="change()" type="text" value="<%= produit.getFrais()%>" name="frais" readonly><br/>
    <textarea onclick="change()" name="description" cols="30" rows="10" readonly><%= produit.getDescription()%></textarea><br/>
    <input type="submit" value="Mettre à jour" disabled>

</form>
<% }
%>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" src="assets/js/script.js"></script>
<%@include file="includes/footer.jsp" %>


