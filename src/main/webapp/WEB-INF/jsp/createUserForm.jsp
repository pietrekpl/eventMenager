<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 29.07.2019
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create User</title>
    <link href='https://fonts.googleapis.com/css?family=Amatic SC' rel='stylesheet'>
    <style>
        .errors {
            color: red;
        }
        body {
            font-family: 'Amatic SC';font-size: 24px;
            font-weight: bold;
            color: black;
        }

    </style>
</head>

<body style="background-color: white;">

<h1>Create new User :</h1>
<br>
<form:form method="POST" action="/createUser/confirm" modelAttribute="user">
    First Name : <form:input path="name"></form:input>
    <form:errors path="name" cssClass="errors"> </form:errors><br>
    Last Name : <form:input path="lastName"></form:input>
    <form:errors path="lastName" cssClass="errors"> </form:errors><br>
    Login : <form:input path="login"></form:input>
    <form:errors path="login" cssClass="errors"> </form:errors><br>
    Password : <form:password path="password"></form:password><br>
    Email : <form:input path="email"></form:input><br>
    Date Birth : <form:input path="date" type="date"></form:input>


    <input type="submit" value="Submit">
    <a href="/">Return to main menu</a>

</form:form>
<%--</form>--%>


</body>
</html>