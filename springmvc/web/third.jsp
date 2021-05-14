<%--
  Created by IntelliJ IDEA.
  User: CXC
  Date: 2021/5/12
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>REST</title>
</head>
<body>
<%
    String contextPath = request.getContextPath();
%>
<%--11--%>
<form action="<%=contextPath%>/third/one/1" method="get">

    <input type="submit" value="查询">
</form>
<br>
<hr>
<%--22--%>
<form action="<%=contextPath%>/third/two/" method="post">
    name<input type="text" name="name" value="崔学超"><br>
    age<input type="text" name="age" value="22"><br>
    <input type="submit" value="新增">
</form>
<br>
<hr>
<%--33--%>

<form action="<%=contextPath%>/third/three/1" method="post">
    <input type="hidden" value="put" name="_method">
    <input type="submit" value="修改">
</form>
<br>
<hr>

<%--44--%>

<form action="<%=contextPath%>/third/four/1" method="post">
    <input type="hidden" value="delete" name="_method">
    <input type="submit" value="删除">
</form>
<br>
<hr>


<img src="<%=contextPath%>/resource/img/好看的妞.jpg">
</body>
</html>
