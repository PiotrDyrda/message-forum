<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Message" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message App</title>
</head>
<body>

<jsp:useBean id="user" class="model.User" scope="application"/>
<%
    if (user.getLogin() != "") {
        out.println("<p>" + "USER SET TO: " + user.getLogin() + "</p>");
    }
%>


<jsp:useBean id="messageService" class="model.MessageServices" scope="application"/>

<%
    if (user.getLogin() == "") {
        out.println("<p>NO USER SPECIFIED !</p>");
    } else {
        for (Message message : messageService.getMessage()) {
            out.println("<p>" + user.getLogin() + ": " + message.getContent() + " at: " + message.getTimestamp() + "</p>");
        }
    }
%>

<form action="/add-message" method="post">
    <input type="text" name="content" id="content"/>
    <input type="submit" value="dodaj wiadomosc"/>
</form>

<form action="/set-login" method="post">
    <input type="text" name="login" id="login"/>
    <input type="submit" value="podaj login"/>
</form>


</body>
</html>
