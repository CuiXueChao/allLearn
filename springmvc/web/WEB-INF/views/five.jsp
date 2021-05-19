<%--
  Created by IntelliJ IDEA.
  User: CXC
  Date: 2021/5/14
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--spring标签库的导入--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>fifth</title>
</head>
<body>

<%
    String contextPath = request.getContextPath();
%>

<%--<spring:eval expression="user.birthday"/>--%>

<%--<spring:eval expression="verifyUser.birthday"/>--%>

<%--<spring:eval expression="verifyUser.birthday"/>--%>

<%--<spring:eval expression="verifyUser.name"/>--%>


<form action="<%=contextPath%>/FifthThree" method="post">
    name<input type="text" name="name" value="${verifyUser.name}">${errors.name}<br>
    age<input type="text" name="age" value="${verifyUser.age}">${errors.age}<br>
    birthday<input type="text" name="birthday" value="${verifyUser.birthday}">${errors.birthday}<br>
    <input type="submit" value="提交">
</form>


<form:form action="/FifthFour" method="post" modelAttribute="verifyUser">
    name<form:input path="name"/><form:errors path="name"/>
    age<form:input path="age"/><form:errors path="age"/>
    birthday<form:input path="birthday"/><form:errors path="birthday"/>
    <form:button value="提交">提交</form:button>
</form:form>

</body>
</html>
