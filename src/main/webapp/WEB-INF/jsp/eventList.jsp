<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 03.08.2019
  Time: 11:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body style="background-color: lightsalmon; font-family: 'Comic Sans MS'">
<title>Event List</title>
<h1>List of Events : </h1>
<c:forEach var="event" items="${eventList}">
    <div>   ${event.name} <br>
            ${event.localization}<br>
            ${event.date}
        <br>
        <a href="/delete/${event.id}">Delete</a>
        <a href="/change">Change</a>
        <a href="/details">Details</a>
    </div>

</c:forEach>
<a href="/">Return to main menu</a>
</body>
</html>
