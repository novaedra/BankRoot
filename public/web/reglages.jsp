<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/session.jsp" %>

<%
    String base64Code = (String) request.getAttribute("qrCode");

%>
<% if (base64Code != null && !base64Code.equals("")) {%>
<img src="<%=(base64Code) %>" style="width:500px; height:500px;" />
<% } %>

<%@include file="includes/footer.jsp" %>