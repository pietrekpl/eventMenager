<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 14.08.2019
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href='https://fonts.googleapis.com/css?family=Amatic SC' rel='stylesheet'>
    <title>Comment</title>
    <style>

        body {
            font-family: 'Amatic SC';font-size: 24px;
            font-weight: bold;
            color: black;
        }
    </style>
</head>
<body style="background-color: white">

<c:forEach var="comment" items="${listOfComments}">
    <div style="border: black; border-style: solid ">
    ${comment.author}: ${comment.content}<br>
    </div>
</c:forEach>
<a href="/">Return to Main Menu</a>


</body>
</html>
