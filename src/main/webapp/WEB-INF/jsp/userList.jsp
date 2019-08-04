<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 04.08.2019
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href='https://fonts.googleapis.com/css?family=Amatic SC' rel='stylesheet'>
    <title>User List</title>
    <style>
        body {
            font-family: 'Amatic SC';font-size: 24px;
            font-weight: bold;
            color: black;
        }
    </style>

</head>
<body style="background-color: white;">
<h1>User List : </h1>
<c:forEach var="user" items="${userList}">
    <div>   ${user.name} <br>
            ${user.lastName} <br>
            ${user.login} <br>
            ${user.date}<br>
            ${user.email}<br>
        <a href="/deleteUser/${user.id}">Delete</a>
    </div>

</c:forEach>
<a href="/">Return to main menu</a>

</body>
</html>
