<%--
  Created by IntelliJ IDEA.
  User: jackwang
  Date: 10/26/2024
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--action设置不同，对应不同的参数转换过程--%>
<form action="getDataByPOJO3" method="post">
    <p>姓名：<input type="text" name="pname"></p>
    <p>年龄：<input type="text" name="page"></p>
    <p>性别：
        <input type="radio" name="gender" value="1">男
        <input type="radio" name="gender" value="0">女
    </p>
    <p>爱好：
        <input type="checkbox" name="hobby" value="1">篮球
        <input type="checkbox" name="hobby" value="2">足球
    </p>
    <p>生日：
        <input type="text" name="birthdate">
    </p>
    <p>
        宠物1<input type="text" name="pets[0].petName">类型：<input type="text" name="pets[0].petType">
    </p>
    <p>
        宠物2<input type="text" name="pets[1].petName">类型：<input type="text" name="pets[1].petType">
    </p>
    <p>
        宠物1<input type="text" name="petMap['a'].petName">类型：<input type="text" name="petMap['a'].petType">
    </p>
    <p>
        宠物2<input type="text" name="petMap['b'].petName">类型：<input type="text" name="petMap['b'].petType">
    </p>
    <input type="submit">
</form>

<form action="getCookie">
    <input type="submit" value="get cookie">
</form>

</body>
</html>
