<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 28.07.2019
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Menu</title>
    <link href='https://fonts.googleapis.com/css?family=Amatic SC' rel='stylesheet'>
    <style>
        body {
            font-family: 'Amatic SC';font-size: 24px;
            font-weight: bold;
            color: black;
        }
        a:hover{
            background-color: darkgray;
        }
    </style>

</head>
<body style="background-color: white; ">
<h1>Event Manager Application</h1>
<div style="position:absolute; right: 400px">
    <p style="font-weight: bold">Find Amazing places near you</p>
    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d161355.00149752767!2d18.98268626209002!3d50.809453740056725!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4710b5c54e2ca8af%3A0x854f0d4d1a178236!2sCz%C4%99stochowa!5e0!3m2!1spl!2spl!4v1564934342013!5m2!1spl!2spl" width="600" height="330" frameborder="0" style="border:0" allowfullscreen></iframe>
</div>


<h2 >Entertainment.<br>
      Made Simply.<br>
       Simply Amazing.</h2>
<br>
<a href="/createUser">Create new User</a><br>
<br>
<a href="/createEvent">Create Event</a><br>
<br>
<a href="/showEventList">Show List of events</a><br>
<br>
<a href="/showUserList">Show User List</a>
<br>
<br>
<button style="color: goldenrod; font-family: 'Amatic SC';font-size: 27px; "><a href="/login">LOG IN</a><br></button>
<button style="color: goldenrod; font-family: 'Amatic SC';font-size: 27px;"><a href = "/logout">LOG OUT</a></button>

</body>
</html>
