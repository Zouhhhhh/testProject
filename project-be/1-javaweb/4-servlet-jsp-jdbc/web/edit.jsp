<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/27
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>修改学生信息</h1>
<form action="/update-student" method="post" >
    <input type="hidden" name="id" value="${student.id}">
    姓名：<input type="text" name="name" value="${student.name}"/>
    分数：<input type="text" name="score" value="${student.score}"/>
    <input type="submit" value="修改"/>
</form>


</body>
</html>
