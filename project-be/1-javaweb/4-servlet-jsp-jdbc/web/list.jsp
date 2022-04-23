<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/27
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>

    <h1>学生管理系统</h1>
    <table>
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>分数</th>
            <th>生日</th>
        </tr>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.score}</td>
                <td>${student.birthday}</td>
                <td>
                    <a href="/delete-student?id=${student.id}">删除</a>
                    <a href="/edit-student?id=${student.id}">编辑</a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br/>



</body>
</html>
