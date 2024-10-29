<%--
  Created by IntelliJ IDEA.
  User: jackwang
  Date: 10/28/2024
  Time: 7:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .progress {
            width: 200px;
            height: 10px;
            border: 1px solid #ccc;
            border-radius: 10px;
            margin: 10px 0px;
            overflow: hidden;
        }
        /* 初始状态设置进度条宽度为0px */
        .progress > div {
            width: 0px;
            height: 100%;
            background-color: yellowgreen;
            transition: all .3s ease;
        }
    </style>
    <script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
    <script type="text/javascript">
        $(function(){
          $("#uploadFile").click(function(){
              var file = $("#photo")[0].files[0]
              if(typeof file === undefined){
                  alert("未选中文件")
                  return;
              }
              var formData =  new FormData();
              formData.append("headphoto",file)
              $.ajax({
                  type:"post",
                  data: formData,
                  url:"fileUpload",
                  processData:false, //告诉浏览器发送对象请求数据
                  contentType:false, //设置请求数据类型为二进制类型。
                  // 其实Formdata会帮我们加contentype为multipart/form-data，并且会生成
                  //边界符boundary，并且会再里面添加content-disposition：form-data，
                  //而append里面key和value，就是添加在content-dispostion后面的name属性值。
                  success:function (result){
                      console.log(result)
                      // alert(result.message)
                      $("#headImg").attr("src",result.url);
                  },
                  xhr: function (){
                      var xhr = new XMLHttpRequest();
                      xhr.upload.addEventListener('progress', function(e){
                          //loaded代表上传了多少
                          //total代表总数为多少
                          var progressRate = (e.loaded / e.total) * 100 + '%';
                          //通过设置进度条的宽度达到效果
                          $('.progress > div').css('width', progressRate);
                      })
                      return xhr;
                  }
              })

          })
        })
    </script>
</head>
<body>
    <form action="addPlayer" method="get">
        <p>账号<input type="text" value="name"></p>
        <p>账号<input type="text" value="password"></p>
        <p>账号<input type="text" value="nickname"></p>
        <p>头像
            <br/>
            <input id="photo" type="file" value="name">
            <br/>
            <a id="uploadFile" href="javascript:void(0)">立即上传</a>
            <br/>
                <%--进度条--%>
            <div class="progress">
                <div></div>
            </div>
            <br/>
            <br/>
            <img id="headImg" style="width: 200px;height: 200px" alt="你还未上传图片">
<%--            <img src="" alt="无" style="">--%>

        </p>
        <p>
            <input type="submit" value="注册">
        </p>
    </form>
</body>
</html>
