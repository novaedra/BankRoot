<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/session.jsp" %>
<%@include file="includes/navbar.jsp" %>

<h1>Activatio de la double auth</h1>
<% String base64Code = (String) request.getAttribute("qrCode"); %>

<img src="<%=(base64Code)%>" alt="qrCode">
<%@include file="includes/footer.jsp" %>