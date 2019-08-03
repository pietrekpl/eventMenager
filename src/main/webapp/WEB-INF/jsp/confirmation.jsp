<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 29.07.2019
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<body style="background-color: lightsalmon; font-family: 'Comic Sans MS'">
<h1>User Confirmed</h1>
Login : ${user.login}
<br>
First Name : ${user.name}
<br>
Last Name : ${user.lastName}
<br>
Email : ${user.email}
<br>
Date of Birth : ${user.date}
<br>
<a href="/">Back to main menu</a>
</body>
</html>
