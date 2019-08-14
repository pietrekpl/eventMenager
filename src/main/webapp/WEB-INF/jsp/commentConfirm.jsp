<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 14.08.2019
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href='https://fonts.googleapis.com/css?family=Amatic SC' rel='stylesheet'>
    <title>Comment List</title>
    <style>

        body {
            font-family: 'Amatic SC';font-size: 24px;
            font-weight: bold;
            color: black;
        }
    </style>
</head>
<body style="background-color: white">
 <b>${comment.author}</b>: <b>"${comment.content}"</b><br>
 <a href="/showDetails/${comment.id}/comment/showCommentList">Show other's comments</a>
</body>
</html>
