<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 30.07.2019
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href='https://fonts.googleapis.com/css?family=Amatic SC' rel='stylesheet'>
    <title>Confirm Event</title>
    <style>
        body {
            font-family: 'Amatic SC';font-size: 24px;
            font-weight: bold;
            color: black;
        }
    </style>
</head>
<body style="background-color: white; ">
<h1> Event create successful</h1>
Event : ${event.name}
<br>
Event Localization : ${event.localization}
<br>
Event Date : ${event.date}
<br>
Access : ${event.access}
<br>
<a href="/">Return to main menu</a>
</body>
</html>
