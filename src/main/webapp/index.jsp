<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>

<form action="testRequest" method="get">

    <input type="submit" value="提交">
</form>

<form action="testRequest3" method="get">
    <input type="text" name="username">
    <input type="text" name="password">
    <input type="submit" value="提交">
</form>


<form action="testRequest4" method="get">
    <input type="text" name="username">
    <input type="text" name="password">
    <input type="submit" value="提交">
</form>

<form action="testRequestHeader" method="get">

    <input type="submit" value="测试请求头">
</form>

</body>
</html>
