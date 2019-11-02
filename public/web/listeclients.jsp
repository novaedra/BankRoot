<%@ page import="java.util.*" %>
<%@ page import="webappli.models.Clients" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<body>
    <%
    List<Clients> clients = (List<Clients>) request.getAttribute("result");
    for (Clients clients : clients) {
        out.println(+ clients.getId() + clients.getNom() + clients.getPrenom());

    }
%>
<%@include file="includes/footer.jsp" %>