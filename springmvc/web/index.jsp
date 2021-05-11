<%--
  Created by IntelliJ IDEA.
  User: CXC
  Date: 2021/5/9
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%
    String contextPath = request.getContextPath();
%>
<form action="<%=contextPath%>/one" method="post">
    name<input type="text" name="userName">
    <input type="submit" value="提交 ">
</form>

<hr>
<%--
    private String name;
    private Integer age;
    private List<String> hobby;
    private Map<String, String> parents;
    private String[] nickname;
    private User user;
--%>
<form action="<%=contextPath%>/two" method="post">
    name<input type="text" name="name" value="崔学超"><br>
    age<input type="text" name="age" value="22"><br>
    <%--针对有序集合要将顺序体现在下标上。--%>
    hobby<input type="checkbox" name="hobby[0]" value="看电影" checked><br>
    hobby<input type="checkbox" name="hobby[1]" value="打游戏" checked><br>
    <%--map的key体现在name属性后的中括号中--%>
    parents<input type="text" name="parents['keyOfDad']" value="cmh" checked><br>
    parents<input type="text" name="parents['keyOfDad']" value="cmh" checked><br>
    <%--数组体现在多个标签有相同的name值--%>
    nickname<input type="text" name="nickname" value="小崔" checked><br>
    nickname<input type="text" name="nickname" value="阿超" checked><br>
    <%--为其他对象赋值，采用属性打点的方式--%>
    user<input type="text" name="user.name" value="aaa" checked><br>
    <input type="submit" value="提交 ">
</form>


${name}
</body>
</html>
