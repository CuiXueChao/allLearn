<%--
  Created by IntelliJ IDEA.
  User: CXC
  Date: 2021/5/23
  Time: 19:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>seven</title>
</head>
<body>
文件下载
<form action="${pageContext.request.contextPath}/SevenTwo">
    <input type="text" name="fileName">
    <input type="submit" value="下载">
</form>

<hr>

单文件上传
<form action="${pageContext.request.contextPath}/SevenThree" method="post" enctype="multipart/form-data">
    <input type="file" name="multipartFile">
    <input type="submit" value="上传">
</form>

<hr>
多文件上传
<form action="${pageContext.request.contextPath}/SevenFour" method="post" enctype="multipart/form-data">
    <input type="file" name="multipartFile" multiple>
    <input type="submit" value="上传">
</form>
<hr>
多文件多线程上传
<form action="${pageContext.request.contextPath}/SevenFive" method="post" enctype="multipart/form-data">
    <input type="file" name="multipartFile" multiple>
    <input type="submit" value="上传">
</form>
</body>
</html>
