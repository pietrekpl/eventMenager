<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 14.08.2019
  Time: 13:51
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
<form:form method="post" action="/showDetails/${comment.id}/comment/show" modelAttribute="comment">
    Author: <form:input path="author"></form:input><br>
    Comment: <form:textarea path="content" cols="50" rows="10"></form:textarea><br>
    <br>
    <input type="submit" value="Post Comment">

</form:form>



</body>
</html>
