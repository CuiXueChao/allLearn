<%--
  Created by IntelliJ IDEA.
  User: CXC
  Date: 2021/6/4
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>拦截器验证是否登录</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath}/eighthTwo">
    简单起见不设置账号密码
    <input type="submit" value="登录">
</form>
</body>
</html>
