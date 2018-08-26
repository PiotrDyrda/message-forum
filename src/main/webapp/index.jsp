<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Message" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message App</title>
</head>
<body>

<jsp:useBean id="messageService" class="model.MessageServices" scope="application"/>

<%

        for (Message message : messageService.getMessage()) {
            out.println("<p>" + message.getContent() + " at: " + message.getTimestamp() + "</p>");
        }

%>

<form action="/add-message" method="post">
    <input type="text" name="content" id="content"/>
    <input type="submit" value="dodaj wiadomosc"/>
</form>

</body>
</html>
