<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 06.08.2019
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <link href='https://fonts.googleapis.com/css?family=Amatic SC' rel='stylesheet'>
    <style>
        body {
            font-family: 'Amatic SC';font-size: 24px;
            font-weight: bold;
            color: black;
        }
    </style>

</head>
<body style="background-color: white">
<H1>To edit : </H1>
<form method="post" action="/edit/${event.id}/save">
Name : <input type="text" value="${event.name}" name="name">
Localization : <input type="text" value="${event.localization}" name="localization">
Date : <input type="date" value="${event.date}" name="date">

   <input type="submit" value="Update">
</form>
</body>
</html>
