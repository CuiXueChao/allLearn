<%--
  Created by IntelliJ IDEA.
  User: CXC
  Date: 2021/5/17
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.min.js"/>
<script>
    //Dom对象加载完成后触发
    $(function () {
        //定义第一个请求的ajax
        $("#sixOne").click(function () {
            $.ajax({
                url: "${pageContext.request.contextPath}/SixthOne",
                method: "post",
                data: "张三",
                contentType: 'application/json',
                dataType: "json",
                success: function (user) {
                    alert(user.name);
                }
            });
        });


    })


</script>
<html>
<head>
    <title>six</title>
</head>
<body>
<button id="sixOne">sixOne</button>
<br><br>
<button id="sixTwo">sixTwo</button>
<br><br>
<button id="sixThree">sixThree</button>
<br><br>

<button id="sixFour">sixFour</button>
<br><br>
</body>
</html>
