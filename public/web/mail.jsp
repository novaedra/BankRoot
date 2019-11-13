<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/head.jsp" %>
<%@include file="includes/session.jsp" %>
<%@include file="includes/navbar.jsp" %>


<form action="SendMail" method="post">
    To:<input type="text" name="to"  /><br/>
    Subject:<input type="text" name="subject"  /><br/>
    Message:<input type="text" name="message"  /><br/>
    <input type="submit" value="send" />
</form>

<%@include file="includes/footer.jsp" %>