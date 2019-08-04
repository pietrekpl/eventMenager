<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 29.07.2019
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href='https://fonts.googleapis.com/css?family=Amatic SC' rel='stylesheet'>
    <title>Create Event</title>
    <style>
        .errors{
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
<h1>Create event</h1>
<br>
<form:form method="POST" action="/createEvent/confirm" modelAttribute="event">
    Event : <form:input path="name"></form:input>
    <form:errors path="name" cssClass="errors"> </form:errors><br>
    Localization : <form:input path="localization"></form:input>
    <form:errors path="localization" cssClass="errors"> </form:errors><br>
    Date: <form:input path="date" type="date"></form:input><br>
    Access : <form:select path="access">
        <form:option value="PUBLIC"></form:option>
        <form:option value="PRIVATE"></form:option>
            </form:select>


    <input type="submit" value="Submit">
    <a href="/">Return to main menu</a>


</form:form>

    </body>
    </html>
