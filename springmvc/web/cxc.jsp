<%--
  Created by IntelliJ IDEA.
  User: CXC
  Date: 2021/5/30
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>资料</title>
</head>
<body>
<center>
    文件上传<br><br>
    <form action="${pageContext.request.contextPath}/cxc" method="post" enctype="multipart/form-data">
        班级：<input type="text" name="classNum"><br><br>
        姓名：<input type="text" name="userName"><br><br>
        学号：<input type="text" name="stuNum"><br><br>
        <input type="file" name="multipartFile">
        <input type="submit" value="上传">
    </form>

    <a href="${pageContext.request.contextPath}/CXC">资料下载</a>
</center>
</body>
</html>
