<%--
  Created by IntelliJ IDEA.
  User: jackwang
  Date: 10/26/2024
  Time: 2:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="getParametersByReq" method="post">
        <input type="text" name="username">
        <input type="text" name="password">
        <input type="submit" value="提交">
    </form>

    <form action="getParametersByNoArg">
        <input type="text" name="username">
        <input type="password" name="password">
        <input type="submit" value="提交">
    </form>
</body>
</html>
