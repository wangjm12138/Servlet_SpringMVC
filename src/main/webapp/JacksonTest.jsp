<%--
  Created by IntelliJ IDEA.
  User: jackwang
  Date: 10/27/2024
  Time: 8:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.7.1.min.js"></script>
    <script>
        $(function (){
            $("#btn").click(function (){
                // $.get("testAjax",{pname:"xx",page:"10"},function(data){
                //     console.log(data)
                // })
                $.ajax({
                    url: "testAjax2",
                    type: "POST",
                    contentType: "application/json",
                    data: JSON.stringify({pname: "xx", page: "10"}),
                    success: function (response) {
                        console.log(response);
                    }
                });
            })
        })
    </script>
</head>
<body>
<input id="btn" type="button" value="testJSON">

</body>
</html>
