<%--
  Created by IntelliJ IDEA.
  User: jackwang
  Date: 10/26/2024
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="testRest/10" method="get">
        <input type="submit" value="GET">
    </form>
<br>
    <form action="testRest/10" method="post">
        <input type="submit" value="POST">
    </form>
    <br>
    <form action="testRest/10" method="post">
        <input type="hidden" name="_method" value="PUT">
        <input type="submit" value="PUT">
    </form>
    <br>
    <form action="testRest/10" method="post">
        <input type="hidden" name="_method" value="DELETE">
        <input type="submit" value="DELETE">
    </form>
</body>
</html>
