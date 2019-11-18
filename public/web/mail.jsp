<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/session.jsp" %>
<%@include file="includes/navbar.jsp" %>


<form action="SendMail" method="post">
    Destinataire&nbsp;:&nbsp;<input type="text" name="to"  /><br/>
    Sujet&nbsp;:&nbsp;<input type="text" name="subject"  /><br/>
    Message&nbsp;:&nbsp;<textarea name="content" id="" cols="70" rows="5"></textarea><br/>
    <input type="submit" value="Envoyer" />
</form>

<%@include file="includes/footer.jsp" %>