<%@ page import="java.util.*" %>
<%@ page import="webappli.models.ClientModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/navbar.jsp" %>

    <%
    List<ClientModel> clientModels = (List<ClientModel>) request.getAttribute("result");
    for (ClientModel clientModel : clientModels) {
        out.println(+ clientModel.getId() + clientModel.getNom() + clientModel.getPrenom());

    }
%>
<%@include file="includes/footer.jsp" %>