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

<h1>新增学生信息</h1>
<form action="/add-student" method="post" >
    姓名：<input type="text" name="naame"/>
    分数：<input type="text" name="score"/>
    <input type="submit" value="提交"/>
</form>


</body>
</html>
